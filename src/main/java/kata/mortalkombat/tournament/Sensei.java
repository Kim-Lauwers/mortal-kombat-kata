package kata.mortalkombat.tournament;

import java.util.Random;

public class Sensei {
    void teachTechniqueToFighter(Fighter fighter) {
        fighter.followTraining(new Training(getRandomTechnique(), getRandomHoursTrained()));
    }

    int getRandomHoursTrained() {
        return new Random().nextInt(10) + 1;
    }

    Technique getRandomTechnique() {
        return Technique.getRandomTechnique();
    }
}