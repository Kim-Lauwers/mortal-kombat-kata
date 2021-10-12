package kata.mortalkombat.tournament;

import kata.mortalkombat.tournament.technique.Attack;
import kata.mortalkombat.tournament.technique.Training;
import kata.mortalkombat.tournament.technique.Trainings;

import java.util.Set;

public class Fighter {
    private final String name;
    private final Trainings trainings;

    private Fighter(String name) {
        this.name = name;
        trainings = new Trainings();
    }

    public static Fighter createFearsomeFighter(String name) {
        return new Fighter(name);
    }

    public String getName() {
        return name;
    }

    public void trainsWith(Sensei sensei) {
        Training senseiTraining = sensei.teachTechnique();
        trainings.addTraining(senseiTraining);
    }

    public Set<Attack> getMasteredTechniques() {
        return trainings.getMasteredTechniques();
    }
}