public class ZombieWarSimulation {

    // lists here
    // generateSurvivors()
    // generateZombies()
    // runBattle()
    // printReport()

    public static void main(String[] args) {

        ZombieWarSimulation sim = new ZombieWarSimulation();

        sim.generateSurvivors(17);
        sim.generateZombies(8);

        sim.runBattle();
        sim.printReport();
    }
}