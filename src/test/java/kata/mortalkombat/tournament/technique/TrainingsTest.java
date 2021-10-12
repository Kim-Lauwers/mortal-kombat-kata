package kata.mortalkombat.tournament.technique;

import org.junit.jupiter.api.Test;

import static kata.mortalkombat.tournament.technique.Attack.GYAKU_TSUKI;
import static kata.mortalkombat.tournament.technique.Attack.OI_TSUKI;
import static org.assertj.core.api.Assertions.assertThat;

class TrainingsTest {

    @Test
    void whenAddingTrainingsUntilMastered_MasteredTechniqueIsReturned() {
        Trainings trainings = new Trainings();

        trainings.addTraining(new Training(OI_TSUKI, 10));
        trainings.addTraining(new Training(OI_TSUKI, 40));
        trainings.addTraining(new Training(OI_TSUKI, 50));

        assertThat(trainings.getMasteredTechniques()).containsExactly(OI_TSUKI);
    }

    @Test
    void whenAddingDifferentTrainingsUntilMastered_MasteredTechniqueIsReturned() {
        Trainings trainings = new Trainings();

        trainings.addTraining(new Training(OI_TSUKI, 10));
        trainings.addTraining(new Training(GYAKU_TSUKI, 10));
        trainings.addTraining(new Training(OI_TSUKI, 40));
        trainings.addTraining(new Training(GYAKU_TSUKI, 90));
        trainings.addTraining(new Training(OI_TSUKI, 50));

        assertThat(trainings.getMasteredTechniques()).containsExactlyInAnyOrder(OI_TSUKI, GYAKU_TSUKI);
    }
}