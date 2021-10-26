package kata.mortalkombat.tournament.technique;

import kata.mortalkombat.tournament.math.Random;

import java.util.Objects;

public class Training {
    private final Technique technique;
    private final double hoursTrained;

    public Training(Technique technique, double hoursTrained) {
        this.technique = technique;
        this.hoursTrained = hoursTrained;
    }

    public boolean isDefense() {
        return technique instanceof Defense;
    }

    public boolean isAttack() {
        return technique instanceof Attack;
    }

    public Technique getTechnique() {
        return technique;
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
        if (!technique.equals(training.technique)) {
            throw new YouCanOnlyTrainTheSameTechniqueException(technique, training.technique);
        }
        return new Training(technique, hoursTrained + training.hoursTrained);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return hoursTrained == training.hoursTrained && technique.equals(training.technique);
    }

    @Override
    public int hashCode() {
        return Objects.hash(technique, hoursTrained);
    }

    @Override
    public String toString() {
        return "Training{" +
                "technique=" + technique +
                ", hoursTrained=" + hoursTrained +
                '}';
    }

    double getHoursTrained() {
        return hoursTrained;
    }
}