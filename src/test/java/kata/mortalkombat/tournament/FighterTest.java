package kata.mortalkombat.tournament;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FighterTest {
    @Test
    void whenCreateFearsomeFighter_ThenFearsomeFighterIsCreated() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");

        assertThat(theHero.getName()).isEqualTo("Liu Kang");
    }

    @Test
    void whenCreateFearsomeFighter_ThenFighterHasARealm(){
        Fighter fighter = Fighter.createFearsomeFighter("Bob");

        assertThat(fighter.getRealm()).isNotNull();
    }
}