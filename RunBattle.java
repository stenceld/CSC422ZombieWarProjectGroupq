import java.util.ArrayList;

public class RunBattle {

    public static void run(ArrayList<Character> survivors, ArrayList<Character> zombies) {
        ArrayList<String> log = new ArrayList<>();

        boolean battleOver = false;

        while (!battleOver) {

            // Survivor attack phase
            for (int i = 0; i < survivors.size(); i++) {
                Character survivor = survivors.get(i);
                if (!survivor.isAlive()) continue;

                for (int j = 0; j < zombies.size(); j++) {
                    Character zombie = zombies.get(j);
                    if (!zombie.isAlive()) continue;

                    survivor.attack(zombie);

                    if (!zombie.isAlive()) {
                        log.add(survivor.getClass().getSimpleName() + " " + i
                                + " killed " + zombie.getClass().getSimpleName() + " " + j);
                    }
                }
            }

            // Check if all zombies are eliminated before zombie phase
            if (allDead(zombies)) {
                battleOver = true;
                break;
            }

            // Zombie attack phase
            for (int j = 0; j < zombies.size(); j++) {
                Character zombie = zombies.get(j);
                if (!zombie.isAlive()) continue;

                for (int i = 0; i < survivors.size(); i++) {
                    Character survivor = survivors.get(i);
                    if (!survivor.isAlive()) continue;

                    zombie.attack(survivor);

                    if (!survivor.isAlive()) {
                        log.add(zombie.getClass().getSimpleName() + " " + j
                                + " killed " + survivor.getClass().getSimpleName() + " " + i);
                    }
                }
            }

            // Check if all survivors are eliminated
            if (allDead(survivors)) {
                battleOver = true;
            }
        }

        int survivorsRemaining = countAlive(survivors);
        int zombiesRemaining = countAlive(zombies);

        // TODO: Pass survivorsRemaining, zombiesRemaining, and log to PrintReport
    }

    private static boolean allDead(ArrayList<Character> list) {
        for (Character c : list) {
            if (c.isAlive()) return false;
        }
        return true;
    }

    private static int countAlive(ArrayList<Character> list) {
        int count = 0;
        for (Character c : list) {
            if (c.isAlive()) count++;
        }
        return count;
    }
}
