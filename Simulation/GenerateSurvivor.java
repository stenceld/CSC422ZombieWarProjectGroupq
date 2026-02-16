package Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Survivor.Child;
import Survivor.Soldier;
import Survivor.Survivor;
import Survivor.Teacher;

public class GenerateSurvivor {

    public static List<Survivor> generateSurvivors(int n) {
        List<Survivor> survivors = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int choice = random.nextInt(3); // 0..2
            switch (choice) {
                case 0 -> survivors.add(new Child());
                case 1 -> survivors.add(new Teacher());
                default -> survivors.add(new Soldier());
            }
        }
        return survivors;
    }
}
