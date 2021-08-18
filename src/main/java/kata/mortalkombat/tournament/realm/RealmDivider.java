package kata.mortalkombat.tournament.realm;

import kata.mortalkombat.tournament.Fighter;

import java.util.Random;

class RealmDivider {
    private static final Random RANDOM = new Random();

    private static <T extends Enum<?>> T randomRealm(Class<T> clazz) {
        int randomRealmIndex = RANDOM.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[randomRealmIndex];
    }

    Realm determineRealmForFighter(Fighter fighter) {
        Realm realm = randomRealm(Realm.class);
        System.out.println(String.format("%s is fighting for: %s", fighter.getName(), realm.name()));
        return realm;
    }
}