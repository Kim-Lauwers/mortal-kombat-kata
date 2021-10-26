package kata.mortalkombat.tournament.technique;

class YouCanOnlyTrainTheSameTechniqueException extends RuntimeException {
    YouCanOnlyTrainTheSameTechniqueException(Technique technique, Technique technique1) {
        super(String.format("Both techniques are not the same %s and %s", technique, technique1));
    }
}