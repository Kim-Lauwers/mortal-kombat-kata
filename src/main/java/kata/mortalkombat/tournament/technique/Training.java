package kata.mortalkombat.tournament.technique;

import kata.mortalkombat.tournament.math.Random;

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

    public Damage getDamage() {
        if (hoursTrained > 100) {
            return new Damage(new Random().random(5, 15));
        }
        return new Damage(new Random().random(0, 5));
    }

    public boolean mastersTechnique() {
        return hoursTrained >= 100;
    }

    public boolean mastersTechniqueForRandori() {
        return hoursTrained >= 80;
    }

    public Training addTraining(Training training) {
        if (!attack.equals(training.attack)) {
            throw new YouCanOnlyTrainTheSameTechniqueException(attack, training.attack);
        }
        return new Training(attack, hoursTrained + training.hoursTrained);
    }
}