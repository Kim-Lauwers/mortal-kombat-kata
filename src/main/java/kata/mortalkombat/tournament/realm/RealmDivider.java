package kata.mortalkombat.tournament.realm;

import kata.mortalkombat.tournament.Fighter;
import kata.mortalkombat.tournament.math.Random;


class RealmDivider {
    private final Random random;

    RealmDivider(Random random) {
        this.random = random;
    }

    private Realm randomRealm() {
        int randomRealmIndex = random.random(Realm.class.getEnumConstants().length);
        return Realm.class.getEnumConstants()[randomRealmIndex];
    }

    Realm determineRealmForFighter(Fighter fighter) {
        Realm realm = randomRealm();
        System.out.printf("%s is fighting for: %s%n", fighter.getName(), realm.name());
        return realm;
    }
}