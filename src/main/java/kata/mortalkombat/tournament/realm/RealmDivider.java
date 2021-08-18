package kata.mortalkombat.tournament.realm;

import kata.mortalkombat.tournament.Fighter;

import java.util.Random;

class RealmDivider {
    private static final Random RANDOM = new Random();

    private static Realm randomRealm() {
        int randomRealmIndex = RANDOM.nextInt(Realm.class.getEnumConstants().length);
        return Realm.class.getEnumConstants()[randomRealmIndex];
    }

    Realm determineRealmForFighter(Fighter fighter) {
        Realm realm = randomRealm();
        System.out.printf("%s is fighting for: %s%n", fighter.getName(), realm.name());
        return realm;
    }
}