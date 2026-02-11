public class Child extends Survivor{

    //this is to fix the srarting health for child
    private static final int START_HEALTH = 20;


    //same as the first but for power
    private static final int START_ATTACK = 2;


    //this is the default constructor
    //this will senmd the child's starting stats up the inheritance chain
    public Child() {
        super(START_HEALTH, START_ATTACK);
    }
}
