

public class Tank extends Zombie {

    // fixed starting health for tank
    private static final int START_HEALTH = 150;

    // fixed starting attack power for tank
    private static final int START_ATTACK = 20;

   
    public Tank() {
        super(START_HEALTH, START_ATTACK);
    }
}
