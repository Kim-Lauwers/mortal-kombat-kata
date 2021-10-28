package kata.mortalkombat.tournament;

class Fighter {
    private final String name;
    private final Realm realm;

    private Fighter(String name) {
        this.name = name;
        this.realm = Realm.getRandomRealm();

    }

    static Fighter createFearsomeFighter(String name) {
        return new Fighter(name);
    }

    public String getName() {
        return name;
    }

    public Realm getRealm() {
        return realm;
    }
}