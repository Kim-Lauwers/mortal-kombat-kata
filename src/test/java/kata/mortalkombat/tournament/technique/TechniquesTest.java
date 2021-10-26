package kata.mortalkombat.tournament.technique;

import org.junit.jupiter.api.Test;

import static kata.mortalkombat.tournament.technique.Attack.GYAKU_TSUKI;
import static kata.mortalkombat.tournament.technique.Attack.HIZA_GERI;
import static kata.mortalkombat.tournament.technique.Attack.MAE_GERI;
import static kata.mortalkombat.tournament.technique.Attack.OI_TSUKI;
import static kata.mortalkombat.tournament.technique.Defense.GEDAN_BARAI;
import static org.assertj.core.api.Assertions.assertThat;

class TechniquesTest {

    @Test
    void whenAddingTrainingsUntilMastered_MasteredTechniqueIsReturned() {
        Techniques techniques = new Techniques();

        techniques.addTraining(new Training(OI_TSUKI, 10));
        techniques.addTraining(new Training(OI_TSUKI, 40));
        techniques.addTraining(new Training(OI_TSUKI, 50));

        assertThat(techniques.getMasteredTechniques()).containsExactly(OI_TSUKI);
    }

    @Test
    void whenAddingDifferentTrainingsUntilMastered_MasteredTechniqueIsReturned() {
        Techniques techniques = new Techniques();

        techniques.addTraining(new Training(OI_TSUKI, 10));
        techniques.addTraining(new Training(GYAKU_TSUKI, 10));
        techniques.addTraining(new Training(OI_TSUKI, 40));
        techniques.addTraining(new Training(GYAKU_TSUKI, 90));
        techniques.addTraining(new Training(OI_TSUKI, 50));

        assertThat(techniques.getMasteredTechniques()).containsExactlyInAnyOrder(OI_TSUKI, GYAKU_TSUKI);
    }

    @Test
    void whenAddingTrainingsUntilMastered_hasRandoriTechniquesReturnTrue() {
        Techniques techniques = new Techniques();

        techniques.addTraining(new Training(OI_TSUKI, 80));

        assertThat(techniques.hasRandoriTechniques()).isTrue();
    }

    @Test
    void whenAddingTrainingsNotUntilMastered_hasRandoriTechniquesReturnTrue() {
        Techniques techniques = new Techniques();

        techniques.addTraining(new Training(OI_TSUKI, 79));

        assertThat(techniques.hasRandoriTechniques()).isFalse();
    }

    @Test
    void whenAddingDefenseTrainingsAndAtLeastOneAttackMastered_FullDefenseIsTrained() {
        Techniques techniques = new Techniques();

        techniques.addTraining(new Training(MAE_GERI, 100));
        techniques.addTraining(new Training(GEDAN_BARAI, 80));

        assertThat(techniques.getRandoriTechniques()).containsExactlyInAnyOrder(new Training(MAE_GERI, 100),
                new Training(GEDAN_BARAI, 80));
    }

    @Test
    void whenAddingDefenseTrainingsAndNotOneAttackMastered_HalfDefenseIsTrained() {
        Techniques techniques = new Techniques();

        techniques.addTraining(new Training(HIZA_GERI, 100));
        techniques.addTraining(new Training(GEDAN_BARAI, 80));

        assertThat(techniques.getRandoriTechniques()).containsExactlyInAnyOrder(new Training(HIZA_GERI, 100));
    }

    @Test
    void whenAddingDefenseTrainingsAndNotOneAttackMastered_HalfDefenseIsTrainedAndNotFullInteger() {
        Techniques techniques = new Techniques();

        techniques.addTraining(new Training(HIZA_GERI, 100));
        techniques.addTraining(new Training(GEDAN_BARAI, 80));
        techniques.addTraining(new Training(GEDAN_BARAI, 87));

        assertThat(techniques.getRandoriTechniques()).containsExactlyInAnyOrder(new Training(HIZA_GERI, 100),
                new Training(GEDAN_BARAI, 83.5));
    }
}