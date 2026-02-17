import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Release 2 simulation
public class ZombieWarSimulation {

    private final List<Survivor> survivors = new ArrayList<>();
    private final List<Zombie> zombies = new ArrayList<>();
    private final Random rand = new Random();

    // Generates survivors with individual IDs per type
    public void generateSurvivors(int n) {

        survivors.clear();

        int childId = 0;
        int teacherId = 0;
        int soldierId = 0;

        for (int i = 0; i < n; i++) {
            int choice = rand.nextInt(3);

            if (choice == 0) survivors.add(new Child(childId++));
            else if (choice == 1) survivors.add(new Teacher(teacherId++));
            else survivors.add(new Soldier(soldierId++));
        }
    }

    // Generates zombies with individual IDs per type
    public void generateZombies(int n) {

        zombies.clear();

        int commonId = 0;
        int tankId = 0;

        for (int i = 0; i < n; i++) {
            int choice = rand.nextInt(2);

            if (choice == 0) zombies.add(new CommonInfected(commonId++));
            else zombies.add(new Tank(tankId++));
        }
    }

    // Runs battle until one side is completely eliminated
    public void runBattle() {

        while (countAliveSurvivors() > 0 && countAliveZombies() > 0) {

            // Survivors attack first
            for (Survivor s : survivors) {
                if (!s.isAlive()) continue;

                for (Zombie z : zombies) {
                    if (!z.isAlive()) continue;

                    boolean wasAlive = z.isAlive();
                    s.attack(z);

                    // Print kill message if zombie died
                    if (wasAlive && !z.isAlive()) {
                        System.out.println(s.getTypeName() + " " + s.getId()
                                + " killed " + z.getTypeName() + " " + z.getId());
                    }
                }
            }

            // Zombies attack next
            for (Zombie z : zombies) {
                if (!z.isAlive()) continue;

                for (Survivor s : survivors) {
                    if (!s.isAlive()) continue;

                    boolean wasAlive = s.isAlive();
                    z.attack(s);

                    // Print kill message if survivor died
                    if (wasAlive && !s.isAlive()) {
                        System.out.println(z.getTypeName() + " " + z.getId()
                                + " killed " + s.getTypeName() + " " + s.getId());
                    }
                }
            }
        }
    }

    // Prints breakdown of initial counts and final outcome
    public void printReport() {

        int childCount = 0, teacherCount = 0, soldierCount = 0;
        for (Survivor s : survivors) {
            if (s instanceof Child) childCount++;
            else if (s instanceof Teacher) teacherCount++;
            else if (s instanceof Soldier) soldierCount++;
        }

        int commonCount = 0, tankCount = 0;
        for (Zombie z : zombies) {
            if (z instanceof CommonInfected) commonCount++;
            else if (z instanceof Tank) tankCount++;
        }

        System.out.println("We have " + survivors.size()
                + " survivors trying to make it to safety ("
                + childCount + " children, "
                + teacherCount + " teachers, "
                + soldierCount + " soldiers)");

        System.out.println("But there are " + zombies.size()
                + " zombies waiting for them ("
                + commonCount + " common infected, "
                + tankCount + " tanks)");

        System.out.println();

        int survivorsAlive = countAliveSurvivors();

        if (survivorsAlive == 0) {
            System.out.println("None of the survivors made it.");
        } else {
            System.out.println("It seems " + survivorsAlive
                    + " have made it to safety.");
        }
    }

    private int countAliveSurvivors() {
        int count = 0;
        for (Survivor s : survivors) {
            if (s.isAlive()) count++;
        }
        return count;
    }

    private int countAliveZombies() {
        int count = 0;
        for (Zombie z : zombies) {
            if (z.isAlive()) count++;
        }
        return count;
    }

    public static void main(String[] args) {

        ZombieWarSimulation sim = new ZombieWarSimulation();

        // Use sample numbers from assignment
        int survivorCount = 5;
        int zombieCount = 9;

        sim.generateSurvivors(survivorCount);
        sim.generateZombies(zombieCount);

        sim.runBattle();
        sim.printReport();
    }
}
