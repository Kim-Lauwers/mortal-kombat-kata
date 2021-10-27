package kata.mortalkombat.tournament.fighter;

class SameRealmException extends RuntimeException {
    SameRealmException() {
        super("The fighters cannot fight a Kumite, they are from the same realm");
    }
}