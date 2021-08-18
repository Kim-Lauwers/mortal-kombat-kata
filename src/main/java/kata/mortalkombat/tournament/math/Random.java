package kata.mortalkombat.tournament.math;

public class Random {
    private static final java.util.Random RANDOM = new java.util.Random();

    public int random(int upperBound) {
        return RANDOM.nextInt(upperBound);
    }
}