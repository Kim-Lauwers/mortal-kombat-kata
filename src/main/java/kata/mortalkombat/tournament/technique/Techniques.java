package kata.mortalkombat.tournament.technique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toUnmodifiableSet;

public class Techniques {
    private final Set<Training> techniques = new HashSet<>();

    public void addTraining(Training newTraining) {
        Optional<Training> optionalTraining = techniques
                .stream()
                .filter(training -> newTraining.getTechnique().equals(training.getTechnique()))
                .findFirst();

        Training cumulTraining = optionalTraining
                .map(training -> training.addTraining(newTraining))
                .orElse(newTraining);

        if (newTraining.isDefense() && !hasAtLeastOneAttackWhichCanBeDefendendBy((Defense) newTraining.getTechnique())) {
            cumulTraining = new Training(newTraining.getTechnique(), optionalTraining.map(Training::getHoursTrained).orElse(0d) + (newTraining.getHoursTrained() / 2));
        }

        optionalTraining.ifPresent(techniques::remove);
        techniques.add(cumulTraining);
    }

    public Training getRandomRandoriAttackTechnique() {
        ArrayList<Training> techniques = new ArrayList<>(getRandoriAttackTechniques());
        Collections.shuffle(techniques);
        return techniques.get(0);
    }

    public Set<Technique> getMasteredTechniques() {
        return techniques.stream()
                .filter(Training::mastersTechnique)
                .map(Training::getTechnique)
                .collect(toUnmodifiableSet());
    }

    public boolean hasRandoriTechniques() {
        return !getRandoriAttackTechniques().isEmpty();
    }

    public boolean hasMasteredTechniques() {
        return !getMasteredTechniques().isEmpty();
    }

    Set<Training> getRandoriAttackTechniques() {
        return techniques.stream()
                .filter(Training::mastersTechniqueForRandori)
                .filter(Training::isAttack)
                .collect(toUnmodifiableSet());
    }

    Set<Training> getRandoriTechniques() {
        return techniques.stream()
                .filter(Training::mastersTechniqueForRandori)
                .collect(toUnmodifiableSet());
    }

    public Optional<Training> findDefenseFor(Attack attack) {
        return getRandoriTechniques()
                .stream()
                .filter(Training::isDefense)
                .filter(training -> ((Defense) training.getTechnique()).canDefendAgainst(attack))
                .findFirst();
    }

    private boolean hasAtLeastOneAttackWhichCanBeDefendendBy(Defense defense) {
        return techniques
                .stream()
                .filter(Training::isAttack)
                .anyMatch(attack -> defense.canDefendAgainst((Attack) attack.getTechnique()));
    }
}