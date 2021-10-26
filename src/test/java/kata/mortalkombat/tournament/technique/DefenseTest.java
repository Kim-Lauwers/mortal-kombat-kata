package kata.mortalkombat.tournament.technique;

import org.junit.jupiter.api.Test;

import static kata.mortalkombat.tournament.technique.Attack.URA_MAWASHI_GERI;
import static kata.mortalkombat.tournament.technique.Attack.YOKO_GERI;
import static org.assertj.core.api.Assertions.assertThat;

class DefenseTest {
    @Test
    void givenDefense_WhenCanDefend_ThenReturnsTrue() {
        assertThat(Defense.TAI_SABAKI.canDefendAgainst(YOKO_GERI)).isTrue();
    }

    @Test
    void givenDefense_WhenCannotDefend_ThenReturnsFalse() {
        assertThat(Defense.TAI_SABAKI.canDefendAgainst(URA_MAWASHI_GERI)).isFalse();
    }
}