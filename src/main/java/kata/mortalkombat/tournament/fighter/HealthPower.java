package kata.mortalkombat.tournament.fighter;

class HealthPower {
    private final int health;

    HealthPower(int health) {
        this.health = health;
    }

    int getHealthPower() {
        return health;
    }

    boolean hasHealthPower() {
        return health > 0;
    }
}
