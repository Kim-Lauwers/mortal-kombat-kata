package kata.mortalkombat.tournament.technique;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DamageTest {
    @Test
    void givenCreatingDamage_WhenGetDamage_ThenReturnsDamage() {
        Damage damage = new Damage(100);

        assertThat(damage.getDamagePower()).isEqualTo(100);
    }
}