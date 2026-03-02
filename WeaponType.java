import java.util.Random;

public enum WeaponType {

    SHOTGUN("Shotgun", 40, 0.6),
    SUBMACHINE_GUN("Submachine Gun", 25, 0.75),
    ASSAULT_RIFLE("Assault Rifle", 30, 0.8),
    PISTOL("Pistol", 18, 0.9),
    AXE("Axe", 35, 0.65),
    CROWBAR("Crowbar", 28, 0.7),
    FRYING_PAN("Frying Pan", 20, 0.85);

    private final String name;
    private final int damage;
    private final double accuracy;

    WeaponType(String name, int damage, double accuracy) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public boolean hits(Random rand) {
        return rand.nextDouble() <= accuracy;
    }

    public static WeaponType randomWeapon(Random rand) {
        WeaponType[] values = WeaponType.values();
        return values[rand.nextInt(values.length)];
    }

    @Override
    public String toString() {
        return name;
    }
}