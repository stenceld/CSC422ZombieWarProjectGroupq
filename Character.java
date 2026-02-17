// Base class for all characters in the simulation.
// Both Survivor and Zombie extend this class.
public abstract class Character {

    protected int health;
    protected int attackPower;

    private final String typeName;
    private final int id;

    public Character(int health, int attackPower, String typeName, int id) {
        this.health = health;
        this.attackPower = attackPower;
        this.typeName = typeName;
        this.id = id;
    }

    // Returns true if character is still alive
    public boolean isAlive() {
        return health > 0;
    }

    // Reduces health when attacked
    public void takeDamage(int damage) {
        if (!isAlive()) return;

        health -= damage;

        // Prevent negative health
        if (health < 0) health = 0;
    }

    // Attacks another character
    public void attack(Character target) {
        if (!isAlive()) return;
        if (target == null || !target.isAlive()) return;

        target.takeDamage(attackPower);
    }

    // Getters used for Release 2 kill logs
    public String getTypeName() {
        return typeName;
    }

    public int getId() {
        return id;
    }
}
