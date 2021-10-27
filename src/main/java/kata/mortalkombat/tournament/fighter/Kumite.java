package kata.mortalkombat.tournament.fighter;

import kata.mortalkombat.tournament.commentator.Commentator;

class Kumite {
    private final Commentator commentator = new Commentator();

    public Fighter fightsKumiteWith(Fighter fighter, Fighter opponent) {
        commentator.giveComment(String.format("%s fights kumite with %s", this, opponent));
        validateIfFightersCanFightKumite(fighter, opponent);

        while (opponent.getHealthPower().hasHealthPower() && fighter.getHealthPower().hasHealthPower()) {
            if (fighter.canFightAKumite()) {
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

    private void validateIfFightersCanFightKumite(Fighter fighter, Fighter opponent) {
        validateDifferentRealm(fighter, opponent);
        validateIfFightersCanFightRandori(fighter, opponent);
    }

    private void validateIfFightersCanFightRandori(Fighter fighter, Fighter opponent) {
        if (!fighter.canFightAKumite() && !opponent.canFightAKumite()) {
            throw new UntrainedException();
        }
    }

    private void validateDifferentRealm(Fighter fighter, Fighter opponent) {
        if (fighter.getRealm().equals(opponent.getRealm())) {
            throw new SameRealmException();
        }
    }
}