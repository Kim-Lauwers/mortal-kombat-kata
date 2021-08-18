package kata.mortalkombat.tournament;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FighterTest {
    @Test
    public void whenCreateFearsomeFighter_ThenFearsomeFighterIsCreated() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");

        assertThat(theHero.getName()).isEqualTo("Liu Kang");
    }
}