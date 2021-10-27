package kata.mortalkombat.tournament.fighter;

import kata.mortalkombat.tournament.Sensei;
import kata.mortalkombat.tournament.commentator.Commentator;
import kata.mortalkombat.tournament.realm.Realm;
import kata.mortalkombat.tournament.realm.RealmDivider;
import kata.mortalkombat.tournament.technique.Attack;
import kata.mortalkombat.tournament.technique.Technique;
import kata.mortalkombat.tournament.technique.Techniques;
import kata.mortalkombat.tournament.technique.Training;

import java.util.Optional;
import java.util.Set;

import static java.lang.Math.max;

public class Fighter {
    private final String name;
    private final Techniques techniques;
    private final Commentator commentator;
    private final Realm realm;
    private HealthPower healthPower;

    private Fighter(String name) {
        this.name = name;
        realm = new RealmDivider().randomRealm();
        techniques = new Techniques();
        healthPower = new HealthPower(100);
        commentator = new Commentator();
    }

    Fighter(RealmDivider realmDivider, String name) {
        this.name = name;
        realm = realmDivider.randomRealm();
        techniques = new Techniques();
        healthPower = new HealthPower(100);
        commentator = new Commentator();
    }

    public static Fighter createFearsomeFighter(String name) {
        return new Fighter(name);
    }

    Realm getRealm() {
        return realm;
    }

    public String getName() {
        return name;
    }

    public void trainsWith(Sensei sensei) {
        Training senseiTraining = sensei.teachTechnique();
        techniques.addTraining(senseiTraining);
        commentator.giveComment(String.format("%s trained %s with his sensei", name, senseiTraining.getTechnique()));
    }

    public Fighter fightsKumiteWith(Fighter opponent) {
        return new Kumite().fightsKumiteWith(this, opponent);
    }

    public Fighter fightsRandoriWith(Fighter opponent) {
        return new Randori().fightsRandoriWith(this, opponent);
    }

    void takesAnAttackAndDefendIfPossible(Training technique) {

        Optional<Training> defense = this.techniques.findDefenseFor((Attack) technique.getTechnique());

        int damagePower = defense
                .map(optionalDefense -> technique.getDamage().getDamagePower() - optionalDefense.getDamage().getDamagePower())
                .orElse(technique.getDamage().getDamagePower());
        defense.ifPresent(
                optionalDefense -> commentator.giveComment(String.format("%s uses defense %s", this, optionalDefense.getTechnique())));

        this.healthPower = new HealthPower(this.healthPower.getHealthPower() - max(damagePower, 0));
        commentator.giveComment(String.format("%s takes an attack an his new healthpower is %s", this, healthPower.getHealthPower()));
    }

    Training throwsAttack() {
        Training technique = this.techniques.getRandomRandoriAttackTechnique();
        commentator.giveComment(String.format("%s throws the attack %s", this, technique.getTechnique()));
        return technique;
    }

    boolean canFightARandori() {
        return techniques.hasRandoriTechniques();
    }

    boolean canFightAKumite() {
        return techniques.hasMasteredTechniques();
    }

    public Set<Technique> getMasteredTechniques() {
        return techniques.getMasteredTechniques();
    }

    public HealthPower getHealthPower() {
        return healthPower;
    }

    @Override
    public String toString() {
        return name;
    }
}