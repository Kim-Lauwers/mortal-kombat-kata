package kata.mortalkombat.tournament.math;

import org.junit.jupiter.api.Test;

import static java.lang.Integer.MAX_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

class RandomTest {
    @Test
    public void whenAskRandom_ThenRandomIsGiven() {
        Random random = new Random();

        assertThat(random.random(MAX_VALUE)).isNotEqualTo(random.random(MAX_VALUE));
    }
}