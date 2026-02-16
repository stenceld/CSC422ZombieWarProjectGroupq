public abstract class Character {

    private int health;
    private final int attackPower;

    public Character(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
    }

    //returns true if the character is still alive
    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }


    //to reduce health when attacked
    public void takeDamage(int amount) {

        //if already dead do nothing
        if (!isAlive()) return;

        health -= amount;
        //to prevent negative health
        if (health < 0) {
            health = 0;
        }
    }

    // for attacking anither character(will only work if both attacker and target are alive.
    public void attack(Character target) {

        if (!isAlive()) return;
        if (target == null || !target.isAlive()) return;

        target.takeDamage(attackPower);
    }


}
