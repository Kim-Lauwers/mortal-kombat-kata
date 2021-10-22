package kata.mortalkombat.tournament.fighter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HealthPowerTest {
    @Test
    void givenCreatingHealthPower_WhenGetHealthPower_ThenReturnsHealthPower() {
        HealthPower healthPower = new HealthPower(100);

        assertThat(healthPower.getHealthPower()).isEqualTo(100);
    }

    @Test
    void givenHealthPowerWithPower_WhenHasHealthPower_ThenReturnsTrue() {
        HealthPower healthPower = new HealthPower(100);

        assertThat(healthPower.hasHealthPower()).isTrue();
    }

    @Test
    void givenHealthPowerWithoutPower_WhenHasHealthPower_ThenReturnsFalse() {
        HealthPower healthPower = new HealthPower(0);

        assertThat(healthPower.hasHealthPower()).isFalse();
    }
}