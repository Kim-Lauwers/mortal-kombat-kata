package kata.mortalkombat.tournament.fighter;

import kata.mortalkombat.tournament.Sensei;
import kata.mortalkombat.tournament.technique.Attack;
import kata.mortalkombat.tournament.technique.Techniques;
import kata.mortalkombat.tournament.technique.Training;

import java.util.Set;

public class Fighter {
    private final String name;
    private final Techniques techniques;
    private HealthPower healthPower;

    private Fighter(String name) {
        this.name = name;
        techniques = new Techniques();
        healthPower = new HealthPower(100);
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
    }

    public Fighter fightsRandoriWith(Fighter fighter) {
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
        if (this.healthPower.hasHealthPower()) {
            return this;
        }
        return fighter;
    }

    private void validateIfFightersCanFightRandori(Fighter fighter) {
        if (!this.canFightARandori() && !fighter.canFightARandori()) {
            throw new UntrainedException();
        }
    }

    private void takesAnAttack(Training technique) {
        this.healthPower = new HealthPower(this.healthPower.getHealthPower() - technique.getDamage().getDamagePower());
        System.out.println("new healthPower: " + healthPower.getHealthPower());
    }

    private Training throwsAttack() {
        Training technique = this.techniques.getRandomRandoriTechnique();
        System.out.println("Throw technique: " + technique.getAttack());
        return technique;
    }

    boolean canFightARandori() {
        return techniques.hasRandoriTechniques();
    }

    public Set<Attack> getMasteredTechniques() {
        return techniques.getMasteredTechniques();
    }

    public HealthPower getHealthPower() {
        return healthPower;
    }
}