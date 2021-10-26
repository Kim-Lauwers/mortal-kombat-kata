package kata.mortalkombat.tournament;

import kata.mortalkombat.tournament.math.Random;
import kata.mortalkombat.tournament.technique.Attack;
import kata.mortalkombat.tournament.technique.Defense;
import kata.mortalkombat.tournament.technique.Technique;
import kata.mortalkombat.tournament.technique.Training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class Sensei {
    public Training teachTechnique() {
        return new Training(randomTechnique(), new Random().random(10));
    }

    private Technique randomTechnique() {
        List<Technique> techniques = new ArrayList<>();
        techniques.addAll(asList(Attack.values()));
        techniques.addAll(asList(Defense.values()));

        Collections.shuffle(techniques);

        return techniques.get(0);
    }
}