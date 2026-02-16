// Base class for all characters
public abstract class Character {

    protected int health;
    protected int attackPower;

    public Character(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void attack(Character target) {
        target.takeDamage(attackPower);
    }

    public int getHealth() {
        return health;
    }
}
