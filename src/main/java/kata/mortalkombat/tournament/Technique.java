package kata.mortalkombat.tournament;

import java.util.Random;

public enum Technique {
    MAE_GERI,
    HIZA_GERI,
    MAWASHI_GERI,
    URA_MAWASHI_GERI,
    TOBI_GERI,
    USHIRO_GERI,
    YOKO_GERI,
    KIZAMI_TSUKI,
    GYAKU_TSUKI,
    OI_TSUKI;

    public static Technique getRandomTechnique() {
        return Technique.class.getEnumConstants()[new Random().ints(0, Technique.class.getEnumConstants().length).findFirst().getAsInt()];
    }

}
