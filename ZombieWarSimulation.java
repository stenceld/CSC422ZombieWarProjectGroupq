import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// ZombieWarSimulation.java
// Release 1.0
// - Randomly generates survivors and zombies
// - Runs battle until one side is dead
// - Prints only the summary report

public class ZombieWarSimulation {

    // Stores all survivors and zombies
    private List<Survivor> survivors = new ArrayList<>();
    private List<Zombie> zombies = new ArrayList<>();

    private Random rand = new Random();

    // Generates n survivors randomly (Child, Teacher, Soldier).
    public void generateSurvivors(int n) {

        survivors.clear();

        for (int i = 0; i < n; i++) {

            int choice = rand.nextInt(3); // 0, 1, 2

            if (choice == 0) {
                survivors.add(new Child());
            } else if (choice == 1) {
                survivors.add(new Teacher());
            } else {
                survivors.add(new Soldier());
            }
        }
    }

    // Generates n zombies randomly (CommonInfected, Tank).
    public void generateZombies(int n) {

        zombies.clear();

        for (int i = 0; i < n; i++) {

            int choice = rand.nextInt(2); // 0 or 1

            if (choice == 0) {
                zombies.add(new CommonInfected());
            } else {
                zombies.add(new Tank());
            }
        }
    }

    // Battle loop for Release 1.
    // Survivors attack zombies.
    // Zombies attack survivors.
    // Repeat until one side is wiped out.
    public void runBattle() {

        while (countAliveSurvivors() > 0 && countAliveZombies() > 0) {

            // Survivors attack zombies
            for (Survivor s : survivors) {
                if (!s.isAlive()) continue;

                for (Zombie z : zombies) {
                    if (!z.isAlive()) continue;
                    s.attack(z);
                }
            }

            // Zombies attack survivors
            for (Zombie z : zombies) {
                if (!z.isAlive()) continue;

                for (Survivor s : survivors) {
                    if (!s.isAlive()) continue;
                    z.attack(s);
                }
            }
        }
    }

    // Prints Release 1 summary output.
    public void printReport() {

        int totalSurvivors = survivors.size();
        int totalZombies = zombies.size();
        int survivorsAlive = countAliveSurvivors();

        System.out.println("We have " + totalSurvivors +
                " survivors trying to make it to safety.");

        System.out.println("But there are " + totalZombies +
                " zombies waiting for them.");

        System.out.println("It seems " + survivorsAlive +
                " have made it to safety.");
    }

    // Counts living survivors
    private int countAliveSurvivors() {
        int count = 0;

        for (Survivor s : survivors) {
            if (s.isAlive()) {
                count++;
            }
        }

        return count;
    }

    // Counts living zombies
    private int countAliveZombies() {
        int count = 0;

        for (Zombie z : zombies) {
            if (z.isAlive()) {
                count++;
            }
        }

        return count;
    }

    // Main method for Release 1 (random counts each run).
    public static void main(String[] args) {

        ZombieWarSimulation sim = new ZombieWarSimulation();

        // Random survivor count: 1 to 20
        int survivorCount = sim.rand.nextInt(20) + 1;

        // Random zombie count: 1 to 15
        int zombieCount = sim.rand.nextInt(15) + 1;

        sim.generateSurvivors(survivorCount);
        sim.generateZombies(zombieCount);

        sim.runBattle();
        sim.printReport();
    }
}
