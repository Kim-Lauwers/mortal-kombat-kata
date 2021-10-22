package kata.mortalkombat.tournament.realm;

import kata.mortalkombat.tournament.math.Random;
import org.junit.jupiter.api.Test;

import static kata.mortalkombat.tournament.fighter.Fighter.createFearsomeFighter;
import static kata.mortalkombat.tournament.realm.Realm.EDENIA;
import static org.assertj.core.api.Assertions.assertThat;

class RealmDividerTest {
    @Test
    public void whenDetermineRealmForWizard_ThenRandomRealmIsGiven() {
        RealmDivider realmDivider = new RealmDivider(new Fixed());

        Realm result = realmDivider.determineRealmForFighter(createFearsomeFighter("Sonya Blade"));

        assertThat(result).isEqualTo(EDENIA);
    }

    private static class Fixed extends Random {
        @Override
        public int random(int upperBound) {
            return 3;
        }
    }
}