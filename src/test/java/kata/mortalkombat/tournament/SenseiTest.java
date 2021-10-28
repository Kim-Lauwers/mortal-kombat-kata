package kata.mortalkombat.tournament;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SenseiTest {

    @Test
    void whenSenseiTeachesTechniques_FighterLearns() {
        Fighter fighter = Fighter.createFearsomeFighter("Robbe Vincent");
        Sensei sensei = new Sensei();

        sensei.teachTechniqueToFighter(fighter);

        assertThat(fighter.getTrainings()).isNotEmpty();
    }

    @Test
    void whenSenseiTeachesTechniques_FighterLearnsTwice() {
        Fighter fighter = Fighter.createFearsomeFighter("Robbe Vincent");
        Sensei sensei = new Sensei() {
            @Override
            int getRandomHoursTrained() {
                return 10;
            }

            @Override
            Technique getRandomTechnique() {
                return Technique.OI_TSUKI;
            }
        };

        sensei.teachTechniqueToFighter(fighter);
        sensei.teachTechniqueToFighter(fighter);

        assertThat(fighter.getTrainings().stream().findFirst()).contains(new Training(Technique.OI_TSUKI, 20));
    }
}