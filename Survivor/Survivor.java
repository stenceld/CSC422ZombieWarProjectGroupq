
//abstract class representing all human survivors
//extends character class


public abstract class Survivor extends Character {

    //passes health and attack values up to the character constructor

    public Survivor(int health, int attackPower) {
        super(health, attackPower);
    }
}
