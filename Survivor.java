public abstract class Survivor extends Character {

    private WeaponType weapon;

    public Survivor(int health, int attackPower, String typeName, int id) {
        super(health, attackPower, typeName, id);
    }

    public void setWeapon(WeaponType weapon) {
        this.weapon = weapon;
    }

    public WeaponType getWeapon() {
        return weapon;
    }
}