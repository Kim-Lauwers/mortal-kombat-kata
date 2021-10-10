package kata.mortalkombat.tournament;

import org.junit.jupiter.api.Test;

import static kata.mortalkombat.tournament.technique.Attack.GYAKU_TSUKI;
import static kata.mortalkombat.tournament.technique.Attack.MAWASHI_GERI;
import static org.assertj.core.api.Assertions.assertThat;

class FighterTest {
    @Test
    void whenCreateFearsomeFighter_ThenFearsomeFighterIsCreated() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");

        assertThat(theHero.getName()).isEqualTo("Liu Kang");
    }

    @Test
    void fighter_AddTechnique_KnowsTechnique() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");

        theHero.addTechnique(GYAKU_TSUKI);

        assertThat(theHero.getTechniques()).containsExactly(GYAKU_TSUKI);
    }

    @Test
    void fighter_AddSameTechnique_KnowsOneTechnique() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");

        theHero.addTechnique(GYAKU_TSUKI);
        theHero.addTechnique(GYAKU_TSUKI);

        assertThat(theHero.getTechniques()).containsExactly(GYAKU_TSUKI);
    }

    @Test
    void fighter_AddMultipleTechnique_KnowsMultipleTechnique() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");

        theHero.addTechnique(GYAKU_TSUKI);
        theHero.addTechnique(MAWASHI_GERI);

        assertThat(theHero.getTechniques()).containsExactly(GYAKU_TSUKI, MAWASHI_GERI);
    }
}