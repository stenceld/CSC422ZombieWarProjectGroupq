import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Release 1 simulation
public class ZombieWarSimulation {

    private List<Survivor> survivors = new ArrayList<>();
    private List<Zombie> zombies = new ArrayList<>();
    private Random rand = new Random();

    // Random survivor generation
    public void generateSurvivors(int n) {

        survivors.clear();

        for (int i = 0; i < n; i++) {

            int choice = rand.nextInt(3);

            if (choice == 0) {
                survivors.add(new Child());
            } else if (choice == 1) {
                survivors.add(new Teacher());
            } else {
                survivors.add(new Soldier());
            }
        }
    }

    // Random zombie generation
    public void generateZombies(int n) {

        zombies.clear();

        for (int i = 0; i < n; i++) {

            int choice = rand.nextInt(2);

            if (choice == 0) {
                zombies.add(new CommonInfected());
            } else {
                zombies.add(new Tank());
            }
        }
    }

    // Battle loop
    public void runBattle() {

        while (countAliveSurvivors() > 0 && countAliveZombies() > 0) {

            // Survivors attack
            for (Survivor s : survivors) {
                if (!s.isAlive()) continue;

                for (Zombie z : zombies) {
                    if (!z.isAlive()) continue;
                    s.attack(z);
                }
            }

            // Zombies attack
            for (Zombie z : zombies) {
                if (!z.isAlive()) continue;

                for (Survivor s : survivors) {
                    if (!s.isAlive()) continue;
                    z.attack(s);
                }
            }
        }
    }

    // Prints summary
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

    private int countAliveSurvivors() {

        int count = 0;

        for (Survivor s : survivors) {
            if (s.isAlive()) {
                count++;
            }
        }

        return count;
    }

    private int countAliveZombies() {

        int count = 0;

        for (Zombie z : zombies) {
            if (z.isAlive()) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        ZombieWarSimulation sim = new ZombieWarSimulation();
        Random rand = new Random();

        // Random number of survivors (5–20)
        int survivorCount = rand.nextInt(16) + 5;

        // Random number of zombies (5–20)
        int zombieCount = rand.nextInt(16) + 5;

        sim.generateSurvivors(survivorCount);
        sim.generateZombies(zombieCount);

        sim.runBattle();
        sim.printReport();
    }
}
