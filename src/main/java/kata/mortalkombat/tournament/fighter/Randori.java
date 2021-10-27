package kata.mortalkombat.tournament.fighter;

import kata.mortalkombat.tournament.commentator.Commentator;

class Randori {
    private final Commentator commentator = new Commentator();

    public Fighter fightsRandoriWith(Fighter fighter, Fighter opponent) {
        commentator.giveComment(String.format("%s fights randori with %s", this, opponent));
        validateIfFightersCanFightRandori(fighter, opponent);

        while (opponent.getHealthPower().hasHealthPower() && fighter.getHealthPower().hasHealthPower()) {
            if (fighter.canFightARandori()) {
                opponent.takesAnAttackAndDefendIfPossible(fighter.throwsAttack());
            } else {
                fighter.takesAnAttackAndDefendIfPossible(opponent.throwsAttack());
            }
        }

        return determinerTheWinner(fighter, opponent);
    }

    private Fighter determinerTheWinner(Fighter fighter, Fighter opponent) {
        Fighter winner = opponent;
        if (fighter.getHealthPower().hasHealthPower()) {
            winner = fighter;
        }
        commentator.giveComment(String.format("The winner is %s", winner));
        return winner;
    }

    private void validateIfFightersCanFightRandori(Fighter fighter, Fighter opponent) {
        if (!fighter.canFightARandori() && !opponent.canFightARandori()) {
            throw new UntrainedException();
        }
    }
}