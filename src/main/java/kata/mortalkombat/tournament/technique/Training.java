package kata.mortalkombat.tournament.technique;

public class Training {
    private final Attack attack;
    private final int hoursTrained;

    public Training(Attack attack, int hoursTrained) {
        this.attack = attack;
        this.hoursTrained = hoursTrained;
    }

    public Attack getAttack() {
        return attack;
    }

    public boolean mastersTechnique() {
        return hoursTrained >= 100;
    }

    public Training addTraining(Training training) {
        if (!attack.equals(training.attack)) {
            throw new YouCanOnlyTrainTheSameTechniqueException(attack, training.attack);
        }
        return new Training(attack, hoursTrained + training.hoursTrained);
    }
}