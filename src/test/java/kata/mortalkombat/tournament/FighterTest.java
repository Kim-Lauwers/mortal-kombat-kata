package kata.mortalkombat.tournament;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FighterTest {

    private Fighter fighter;

    @BeforeEach
    public void setup() {
        fighter = Fighter.createFearsomeFighter("Liu Kang");
    }

    @Test
    void whenCreateFearsomeFighter_ThenFearsomeFighterIsCreated() {

        assertThat(fighter.getName()).isEqualTo("Liu Kang");
    }

    @Test
    void whenCreateFearsomeFighter_ThenFighterHasARealm(){

        assertThat(fighter.getRealm()).isNotNull();
    }

    @Test
    void whenLearnTechnique_ThenTechniqueIsAddedToSet() {

        Technique technique = Technique.GYAKU_TSUKI;
        fighter.learnTechnique(technique);

        assertThat(fighter.getTechniques()).containsExactly(technique);
    }
}
