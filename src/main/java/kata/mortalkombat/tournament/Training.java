package kata.mortalkombat.tournament;

public class Training {
    private final Technique technique;
    private final int hoursTrained;

    public Training(Technique technique, int hoursTrained) {
        this.technique = technique;
        this.hoursTrained = hoursTrained;
    }

    boolean hasCompletedTraining() {
        return hoursTrained > 100;
    }
}
