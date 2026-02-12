

public class CommonInfected extends Zombie {

    // Fixed starting health for CommonInfected
    private static final int START_HEALTH = 30;

    // Fixed starting attack power for CommonInfected
    private static final int START_ATTACK = 5;

   
    public CommonInfected() {
        super(START_HEALTH, START_ATTACK);
    }
}
