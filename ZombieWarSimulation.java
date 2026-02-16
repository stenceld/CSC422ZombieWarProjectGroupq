import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/// ZombieWarSimulation.java
/// Release 1

public class ZombieWarSimulation {

    /// Stores survivors
    private List<Survivor> survivors = new ArrayList<>();

    /// Stores zombies
    private List<Zombie> zombies = new ArrayList<>();

    /// Shared random object
    private Random rand = new Random();


    /// Generates random survivors
    public void generateSurvivors(int n) {

        survivors.clear();

        for (int i = 0; i < n; i++) {

            int choice = rand.nextInt(3); // 0,1,2

            if (choice == 0) {
                survivors.add(new Child());
            }
            else if (choice == 1) {
                survivors.add(new Teacher());
            }
            else {
                survivors.add(new Soldier());
            }
        }
    }


    /// Generates random zombies
    public void generateZombies(int n) {

        zombies.clear();

        for (int i = 0; i < n; i++) {

            int choice = rand.nextInt(2); // 0 or 1

            if (choice == 0) {
                zombies.add(new CommonInfected());
            }
            else {
                zombies.add(new Tank());
            }
        }
    }


    /// Runs battle until one side is eliminated
    public void runBattle() {

        while (countAliveSurvivors() > 0 && countAliveZombies() > 0) {

            /// Survivors attack zombies
            for (Survivor s : survivors) {
                if (!s.isAlive()) continue;

                for (Zombie z : zombies) {
                    if (!z.isAlive()) continue;
                    s.attack(z);
                }
            }

            /// Zombies attack survivors
            for (Zombie z : zombies) {
                if (!z.isAlive()) continue;

                for (Survivor s : survivors) {
                    if (!s.isAlive()) continue;
                    z.attack(s);
                }
            }
        }
    }


    /// Prints Release 1 summary
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


    /// Counts living survivors
    private int countAliveSurvivors() {

        int count = 0;

        for (Survivor s : survivors) {
            if (s.isAlive()) count++;
        }

        return count;
    }


    /// Counts living zombies
    private int countAliveZombies() {

        int count = 0;

        for (Zombie z : zombies) {
            if (z.isAlive()) count++;
        }

        return count;
    }


    /// Main method
    public static void main(String[] args) {

        ZombieWarSimulation sim = new ZombieWarSimulation();

        /// Random survivor count between 1 and 20
        int survivorCount = sim.rand.nextInt(20) + 1;

        /// Random zombie count between 1 and 15
        int zombieCount = sim.rand.nextInt(15) + 1;

        sim.generateSurvivors(survivorCount);
        sim.generateZombies(zombieCount);

        sim.runBattle();
        sim.printReport();
    }
}
