package kata.mortalkombat.tournament;

import kata.mortalkombat.tournament.technique.Training;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static kata.mortalkombat.tournament.technique.Attack.GYAKU_TSUKI;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FighterTest {
    @Mock
    private Sensei sensei;

    @Test
    void whenCreateFearsomeFighter_ThenFearsomeFighterIsCreated() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");

        assertThat(theHero.getName()).isEqualTo("Liu Kang");
    }

    @Test
    void fighter_TrainsWithSensei_GetsTrained() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 100));

        theHero.trainsWith(sensei);

        assertThat(theHero.getMasteredTechniques()).containsExactly(GYAKU_TSUKI);
    }

    @Test
    void fighter_TrainsWithSenseiTwiceForSameTechnique_GetsTrained() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 50));

        theHero.trainsWith(sensei);
        theHero.trainsWith(sensei);

        assertThat(theHero.getMasteredTechniques()).containsExactly(GYAKU_TSUKI);
    }
}