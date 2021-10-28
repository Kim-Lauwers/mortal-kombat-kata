package kata.mortalkombat.tournament;

import java.util.HashSet;
import java.util.Set;

class Fighter {
    private final String name;
    private final Realm realm;
    private final Set<Technique> techniques;

    private Fighter(String name) {
        this.name = name;
        this.realm = Realm.getRandomRealm();
        this.techniques = new HashSet<>();
    }

    static Fighter createFearsomeFighter(String name) {
        return new Fighter(name);
    }

    public void learnTechnique(Technique technique) {
        this.techniques.add(technique);
    }

    public String getName() {
        return name;
    }

    public Realm getRealm() {
        return realm;
    }

    public Set<Technique> getTechniques() {
        return techniques;
    }
}
