package kata.mortalkombat.tournament.fighter;

class UntrainedException extends RuntimeException{
    UntrainedException() {
         super("This fighter has no techniques to fight with.");
     }
 }