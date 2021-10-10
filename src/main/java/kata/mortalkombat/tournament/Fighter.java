package kata.mortalkombat.tournament;

import kata.mortalkombat.tournament.technique.Attack;

import java.util.HashSet;
import java.util.Set;

public class Fighter {
    private final String name;
    private final Set<Attack> techniques = new HashSet<>();

    private Fighter(String name) {
        this.name = name;
    }

    public static Fighter createFearsomeFighter(String name) {
        return new Fighter(name);
    }

    public String getName() {
        return name;
    }

    public void addTechnique(Attack technique) {
        techniques.add(technique);
    }

    public Set<Attack> getTechniques() {
        return techniques;
    }
}