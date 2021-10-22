package kata.mortalkombat.tournament;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SenseiTest {
    @Test
    void whenTeachTechnique_ThenReturnsRandom() {
        Sensei sensei = new Sensei();

        assertThat(sensei.teachTechnique()).isNotNull();
    }
}