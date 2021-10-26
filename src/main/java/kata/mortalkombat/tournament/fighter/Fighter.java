package kata.mortalkombat.tournament.fighter;

import kata.mortalkombat.tournament.Sensei;
import kata.mortalkombat.tournament.commentator.Commentator;
import kata.mortalkombat.tournament.technique.Technique;
import kata.mortalkombat.tournament.technique.Techniques;
import kata.mortalkombat.tournament.technique.Training;

import java.util.Set;

public class Fighter {
    private final String name;
    private final Techniques techniques;
    private final Commentator commentator;
    private HealthPower healthPower;

    private Fighter(String name) {
        this.name = name;
        techniques = new Techniques();
        healthPower = new HealthPower(100);
        commentator = new Commentator();
    }

    public static Fighter createFearsomeFighter(String name) {
        return new Fighter(name);
    }

    public String getName() {
        return name;
    }

    public void trainsWith(Sensei sensei) {
        Training senseiTraining = sensei.teachTechnique();
        techniques.addTraining(senseiTraining);
        commentator.giveComment(String.format("%s trained %s with his sensei", name, senseiTraining.getTechnique()));
    }

    public Fighter fightsRandoriWith(Fighter fighter) {
        commentator.giveComment(String.format("%s fights randori with %s", this, fighter));
        validateIfFightersCanFightRandori(fighter);

        while (fighter.healthPower.hasHealthPower() && this.healthPower.hasHealthPower()) {
            if (this.canFightARandori()) {
                fighter.takesAnAttack(this.throwsAttack());
            } else {
                this.takesAnAttack(fighter.throwsAttack());
            }
        }

        return determinerTheWinner(fighter);
    }

    private Fighter determinerTheWinner(Fighter fighter) {
        Fighter winner = fighter;
        if (this.healthPower.hasHealthPower()) {
            winner = this;
        }
        commentator.giveComment(String.format("The winner is %s", winner));
        return winner;
    }

    private void validateIfFightersCanFightRandori(Fighter fighter) {
        if (!this.canFightARandori() && !fighter.canFightARandori()) {
            throw new UntrainedException();
        }
    }

    private void takesAnAttack(Training technique) {
        this.healthPower = new HealthPower(this.healthPower.getHealthPower() - technique.getDamage().getDamagePower());
        commentator.giveComment(String.format("%s takes an attach an his new healthpower is %s", this, healthPower.getHealthPower()));
    }

    private Training throwsAttack() {
        Training technique = this.techniques.getRandomRandoriTechnique();
        commentator.giveComment(String.format("%s throws the attack %s", this, technique.getTechnique()));
        return technique;
    }

    boolean canFightARandori() {
        return techniques.hasRandoriTechniques();
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