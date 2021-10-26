package kata.mortalkombat.tournament.technique;

import java.util.Arrays;
import java.util.Collection;

import static kata.mortalkombat.tournament.technique.Attack.GYAKU_TSUKI;
import static kata.mortalkombat.tournament.technique.Attack.HIZA_GERI;
import static kata.mortalkombat.tournament.technique.Attack.KIZAMI_TSUKI;
import static kata.mortalkombat.tournament.technique.Attack.MAE_GERI;
import static kata.mortalkombat.tournament.technique.Attack.MAWASHI_GERI;
import static kata.mortalkombat.tournament.technique.Attack.OI_TSUKI;
import static kata.mortalkombat.tournament.technique.Attack.TOBI_GERI;
import static kata.mortalkombat.tournament.technique.Attack.URA_MAWASHI_GERI;
import static kata.mortalkombat.tournament.technique.Attack.USHIRO_GERI;
import static kata.mortalkombat.tournament.technique.Attack.YOKO_GERI;

public enum Defense implements Technique {

    GEDAN_BARAI(MAE_GERI, KIZAMI_TSUKI, GYAKU_TSUKI, OI_TSUKI),
    SUKUI_UKE(MAE_GERI, HIZA_GERI, MAWASHI_GERI),
    MIKZUKI_GUERI_UKE(TOBI_GERI),
    AGE_UKE(URA_MAWASHI_GERI),
    TAI_SABAKI(USHIRO_GERI, YOKO_GERI);

    private final Collection<Attack> attacks;

    Defense(Attack... attacks) {
        this.attacks = Arrays.asList(attacks);
    }

    public boolean canDefendAgainst(Attack attack) {
        return this.attacks.contains(attack);
    }
}