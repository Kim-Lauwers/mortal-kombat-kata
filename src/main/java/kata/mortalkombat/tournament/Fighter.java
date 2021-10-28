package kata.mortalkombat.tournament;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Fighter {
    private final String name;
    private final Realm realm;
    private final Set<Training> trainings;

    private Fighter(String name) {
        this.name = name;
        this.realm = Realm.getRandomRealm();
        this.trainings = new HashSet<>();
    }

    static Fighter createFearsomeFighter(String name) {
        return new Fighter(name);
    }

    public void followTraining(Training training) {
        this.trainings.add(training);
    }

    public String getName() {
        return name;
    }

    public Realm getRealm() {
        return realm;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }
}
