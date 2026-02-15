// Prints Release 1 summary output.
// Shows total survivors, total zombies,
// and how many survivors made it to safety.
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
