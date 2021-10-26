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

    private boolean hasAtLeastOneAttackWhichCanBeDefendendBy(Defense defense) {
        return techniques
                .stream()
                .filter(Training::isAttack)
                .anyMatch(attack -> defense.canDefendAgainst((Attack) attack.getTechnique()));
    }

    public Training getRandomRandoriTechnique() {
        ArrayList<Training> techniques = new ArrayList<>(getRandoriTechniques());
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
        return !getRandoriTechniques().isEmpty();
    }

    Set<Training> getRandoriTechniques() {
        return techniques.stream()
                .filter(Training::mastersTechniqueForRandori)
                .collect(toUnmodifiableSet());
    }
}