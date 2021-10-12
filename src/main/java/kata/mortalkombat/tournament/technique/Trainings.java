package kata.mortalkombat.tournament.technique;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toUnmodifiableSet;

public class Trainings {
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

    public Set<Attack> getMasteredTechniques() {
        return techniques.stream()
                .filter(Training::mastersTechnique)
                .map(Training::getAttack)
                .collect(toUnmodifiableSet());
    }
}