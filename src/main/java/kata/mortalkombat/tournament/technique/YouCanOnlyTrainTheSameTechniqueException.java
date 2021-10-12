package kata.mortalkombat.tournament.technique;

class YouCanOnlyTrainTheSameTechniqueException extends RuntimeException {
    YouCanOnlyTrainTheSameTechniqueException(Attack attack, Attack attack1) {
        super(String.format("Both attacks are not the same %s and %s", attack, attack1));
    }
}