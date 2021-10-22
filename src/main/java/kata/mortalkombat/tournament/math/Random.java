package kata.mortalkombat.tournament.math;

public class Random {
    private static final java.util.Random RANDOM = new java.util.Random();

    public int random(int upperBound) {
        return random(0, upperBound);
    }

    public int random(int lowerBound, int upperBound) {
        return RANDOM.ints(lowerBound, (upperBound + 1)).findFirst().getAsInt();
    }
}