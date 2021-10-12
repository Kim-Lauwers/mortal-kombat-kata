package kata.mortalkombat.tournament;

import kata.mortalkombat.tournament.math.Random;
import kata.mortalkombat.tournament.technique.Attack;
import kata.mortalkombat.tournament.technique.Training;

class Sensei {
    Training teachTechnique() {
        return new Training(Attack.random(), new Random().random(10));
    }
}