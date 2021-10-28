package kata.mortalkombat.tournament;

import java.util.Random;

public enum Realm {
    EARTHREALM,
    OUTWORLD,
    NETHERREALM,
    EDENIA,
    CHAOSREALM,
    ORDERREALM;

    public static Realm getRandomRealm(){
        return Realm.class.getEnumConstants()[new Random().ints(0,Realm.class.getEnumConstants().length).findFirst().getAsInt()];
    }
}
