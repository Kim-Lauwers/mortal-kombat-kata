package kata.mortalkombat.tournament.technique;

import org.junit.jupiter.api.Test;

import static kata.mortalkombat.tournament.technique.Attack.GYAKU_TSUKI;
import static kata.mortalkombat.tournament.technique.Attack.OI_TSUKI;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrainingTest {
    @Test
    void givenCreatingTraining_WhenGetAttack_ThenReturnsAttack() {
        Training training = new Training(GYAKU_TSUKI, 10);

        assertThat(training.getAttack()).isEqualTo(GYAKU_TSUKI);
    }

    @Test
    void givenCreatingTrainingLessThan100Hours_WhenMastersTechnique_ReturnsFalse() {
        Training training = new Training(GYAKU_TSUKI, 99);

        assertThat(training.mastersTechnique()).isFalse();
    }

    @Test
    void givenCreatingTraining100Hours_WhenMastersTechnique_ReturnsTrue() {
        Training training = new Training(GYAKU_TSUKI, 100);

        assertThat(training.mastersTechnique()).isTrue();
    }

    @Test
    void givenTraining_WhenAddTraining_HoursAreAdded() {
        Training training = new Training(GYAKU_TSUKI, 90);
        Training training2 = new Training(GYAKU_TSUKI, 6);
        Training training3 = new Training(GYAKU_TSUKI, 4);

        Training finalTraining = training.addTraining(training2).addTraining(training3);

        assertThat(finalTraining.mastersTechnique()).isTrue();
    }

    @Test
    void givenTraining_WhenAddTrainingForOtherTechnique_ThrowsYouCanOnlyTrainTheSameTechniqueException() {
        Training training = new Training(GYAKU_TSUKI, 90);
        Training training2 = new Training(OI_TSUKI, 6);

        assertThatThrownBy(() -> training.addTraining(training2))
                .isInstanceOf(YouCanOnlyTrainTheSameTechniqueException.class)
                .hasMessage("Both attacks are not the same GYAKU_TSUKI and OI_TSUKI");
    }
}