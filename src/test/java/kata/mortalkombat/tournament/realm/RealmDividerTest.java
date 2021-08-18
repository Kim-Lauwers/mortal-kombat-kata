package kata.mortalkombat.tournament.realm;

import org.junit.jupiter.api.Test;

import static kata.mortalkombat.tournament.Fighter.createFearsomeFighter;
import static org.assertj.core.api.Assertions.assertThat;

class RealmDividerTest {
    @Test
    public void determineHouseForWizard() {
        RealmDivider realmDivider = new RealmDivider();

        Realm result = realmDivider.determineRealmForFighter(createFearsomeFighter("Sonya Blade"));

        assertThat(result).isIn((Object[]) Realm.values());
    }
}