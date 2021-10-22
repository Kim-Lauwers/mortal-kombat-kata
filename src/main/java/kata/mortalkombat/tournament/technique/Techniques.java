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
                .filter(training -> newTraining.getAttack().equals(training.getAttack()))
                .findFirst();

        Training cumulTraining = optionalTraining
                .map(training -> training.addTraining(newTraining))
                .orElse(newTraining);
        optionalTraining.ifPresent(techniques::remove);

        techniques.add(cumulTraining);
    }

    public Training getRandomRandoriTechnique() {
        ArrayList<Training> techniques = new ArrayList<>(getRandoriTechniques());
        Collections.shuffle(techniques);
        return techniques.get(0);
    }

    public Set<Attack> getMasteredTechniques() {
        return techniques.stream()
                .filter(Training::mastersTechnique)
                .map(Training::getAttack)
                .collect(toUnmodifiableSet());
    }

    public boolean hasRandoriTechniques() {
        return !getRandoriTechniques().isEmpty();
    }

    private Set<Training> getRandoriTechniques() {
        return techniques.stream()
                .filter(Training::mastersTechniqueForRandori)
                .collect(toUnmodifiableSet());
    }
}