package kata.mortalkombat.tournament.technique;

import kata.mortalkombat.tournament.math.Random;

public enum Attack {
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

    public static Attack random() {
        return values()[new Random().random(values().length)];
    }
}