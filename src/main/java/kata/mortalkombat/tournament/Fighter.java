package kata.mortalkombat.tournament;

class Fighter {
    private final String name;

    private Fighter(String name) {
        this.name = name;
    }

    static Fighter createFearsomeFighter(String name) {
        return new Fighter(name);
    }

    public String getName() {
        return name;
    }
}