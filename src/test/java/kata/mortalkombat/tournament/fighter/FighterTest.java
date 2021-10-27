package kata.mortalkombat.tournament.fighter;

import kata.mortalkombat.tournament.Sensei;
import kata.mortalkombat.tournament.math.Random;
import kata.mortalkombat.tournament.realm.RealmDivider;
import kata.mortalkombat.tournament.technique.Training;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static kata.mortalkombat.tournament.technique.Attack.GYAKU_TSUKI;
import static kata.mortalkombat.tournament.technique.Attack.OI_TSUKI;
import static kata.mortalkombat.tournament.technique.Defense.GEDAN_BARAI;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    void whenCreateFearsomeFighter_ThenHealtIs100() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");

        assertThat(theHero.getHealthPower().getHealthPower()).isEqualTo(100);
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

    @Test
    void givenSkilledFighter_WhenFightsRandoriWithUnskilledFighter_ThenSkilledFighterWins() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 80));
        theHero.trainsWith(sensei);

        Fighter theFriend = Fighter.createFearsomeFighter("Kitana");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 79));
        theFriend.trainsWith(sensei);


        Fighter winner = theHero.fightsRandoriWith(theFriend);
        assertThat(winner).isEqualTo(theHero);
        assertThat(winner.getHealthPower().hasHealthPower()).isTrue();
        assertThat(theFriend.getHealthPower().hasHealthPower()).isFalse();
    }

    @Test
    void givenSkilledFighterHasDefense_WhenFightsRandori_ThenSkilledFighterWins() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 80));
        theHero.trainsWith(sensei);
        when(sensei.teachTechnique()).thenReturn(new Training(GEDAN_BARAI, 80));
        theHero.trainsWith(sensei);

        Fighter theFriend = Fighter.createFearsomeFighter("Kitana");
        when(sensei.teachTechnique()).thenReturn(new Training(OI_TSUKI, 80));
        theFriend.trainsWith(sensei);

        Fighter winner = theHero.fightsRandoriWith(theFriend);
        assertThat(winner).isEqualTo(theHero);
        assertThat(winner.getHealthPower().hasHealthPower()).isTrue();
        assertThat(theFriend.getHealthPower().hasHealthPower()).isFalse();
    }

    @Test
    void givenUnSkilledFighter_WhenFightsRandoriWithSkilledFighter_ThenSkilledFighterWins() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 79));
        theHero.trainsWith(sensei);

        Fighter theFriend = Fighter.createFearsomeFighter("Kitana");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 80));
        theFriend.trainsWith(sensei);


        Fighter winner = theHero.fightsRandoriWith(theFriend);
        assertThat(winner).isEqualTo(theFriend);
        assertThat(winner.getHealthPower().hasHealthPower()).isTrue();
        assertThat(theHero.getHealthPower().hasHealthPower()).isFalse();
    }

    @Test
    void givenUnSkilledFighter_WhenFightsKumiteWithSkilledFighter_ThenSkilledFighterWins() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 99));
        theHero.trainsWith(sensei);

        Fighter opponent = Fighter.createFearsomeFighter("Kitana");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 100));
        opponent.trainsWith(sensei);


        Fighter winner = theHero.fightsKumiteWith(opponent);
        assertThat(winner).isEqualTo(opponent);
        assertThat(winner.getHealthPower().hasHealthPower()).isTrue();
        assertThat(theHero.getHealthPower().hasHealthPower()).isFalse();
    }

    @Test
    void givenSkilledFighter_WhenFightsKumiteWithUnSkilledFighter_ThenSkilledFighterWins() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 100));
        theHero.trainsWith(sensei);

        Fighter opponent = Fighter.createFearsomeFighter("Kitana");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 99));
        opponent.trainsWith(sensei);


        Fighter winner = theHero.fightsKumiteWith(opponent);
        assertThat(winner).isEqualTo(theHero);
        assertThat(winner.getHealthPower().hasHealthPower()).isTrue();
        assertThat(opponent.getHealthPower().hasHealthPower()).isFalse();
    }

    @Test
    void givenUnskilledFighter_WhenFightsRandoriWithUnskilledFighter_ThenThrowUntrainedException() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 79));
        theHero.trainsWith(sensei);

        Fighter theFriend = Fighter.createFearsomeFighter("Kitana");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 79));
        theFriend.trainsWith(sensei);

        assertThatThrownBy(() -> theHero.fightsRandoriWith(theFriend))
                .isInstanceOf(UntrainedException.class)
                .hasMessage("This fighter has no techniques to fight with.");
    }

    @Test
    void givenUnskilledFighter_WhenFightsKumiteWithUnskilledFighter_ThenThrowUntrainedException() {
        Fighter theHero = Fighter.createFearsomeFighter("Liu Kang");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 99));
        theHero.trainsWith(sensei);

        Fighter theOpponent = Fighter.createFearsomeFighter("Kitana");
        when(sensei.teachTechnique()).thenReturn(new Training(GYAKU_TSUKI, 99));
        theOpponent.trainsWith(sensei);

        assertThatThrownBy(() -> theHero.fightsKumiteWith(theOpponent))
                .isInstanceOf(UntrainedException.class)
                .hasMessage("This fighter has no techniques to fight with.");
    }

    @Test
    void givenfighter_WhenFightsKumiteWithFighterOfSameRealm_ThenThrowSameRealmException() {
        Fighter theHero = new Fighter(new RealmDivider(new Fixed()), "Liu Kang");
        Fighter theFriend = new Fighter(new RealmDivider(new Fixed()), "Kitana");

        assertThatThrownBy(() -> theHero.fightsKumiteWith(theFriend))
                .isInstanceOf(SameRealmException.class)
                .hasMessage("The fighters cannot fight a Kumite, they are from the same realm");
    }

    private static class Fixed extends Random {
        @Override
        public int random(int upperBound) {
            return 3;
        }
    }
}