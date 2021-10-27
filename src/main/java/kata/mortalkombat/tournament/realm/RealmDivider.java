package kata.mortalkombat.tournament.realm;

import kata.mortalkombat.tournament.math.Random;


public class RealmDivider {
    private final Random random;

    public RealmDivider(Random random) {
        this.random = random;
    }

    public RealmDivider() {
        this.random = new Random();
    }

    public Realm randomRealm() {
        int randomRealmIndex = random.random(Realm.class.getEnumConstants().length );
        return Realm.class.getEnumConstants()[randomRealmIndex];
    }
}