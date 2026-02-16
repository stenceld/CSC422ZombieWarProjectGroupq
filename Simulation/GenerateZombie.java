package Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Zombie.CommonInfected;
import Zombie.Tank;
import Zombie.Zombie;

public class GenerateZombie {

    public static List<Zombie> generateZombies(int n) {
        List<Zombie> zombies = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int choice = random.nextInt(2); // only 2 zombie types 
            if (choice == 0) zombies.add(new CommonInfected());
            else zombies.add(new Tank());
        }
        return zombies;
    }
}
