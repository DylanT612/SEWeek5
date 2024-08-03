import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    // Create two lists, generate a list of zombies and survivors
    public static void main(String[] args) {
        List<Zombie> zombies = generateZombies();
        List<Survivor> survivors = generateSurvivors();

        // Create a battleground with the zombies and survivors
        Battlefield battlefield = new Battlefield(zombies, survivors);
        battlefield.simulateBattle();
    }

    // Generate zombies in the list
    private static List<Zombie> generateZombies() {
        // Create a new list
        List<Zombie> zombies = new ArrayList<>();
        Random random = new Random();
        int numZombies = random.nextInt(20) + 1;
        // Generate 1-20 zombies using true or false from javas random library
        for (int i = 0; i < numZombies; i++) {
            if (random.nextBoolean()) {
                zombies.add(new CommonInfected(i));
            } else {
                zombies.add(new Tank(i));
            }
        }
        // return the list
        return zombies;
    }

    // Generate survivors in the list
    private static List<Survivor> generateSurvivors() {
        // Create new list
        List<Survivor> survivors = new ArrayList<>();
        Random random = new Random();
        int numSurvivors = random.nextInt(20) + 1;
        // Generate 1-20 random survivors using 1,2,3 from javas random library
        for (int i = 0; i < numSurvivors; i++) {
            int choice = random.nextInt(3);
            switch (choice) {
                case 0:
                    survivors.add(new Scientist(i));
                    break;
                case 1:
                    survivors.add(new Civilian(i));
                    break;
                case 2:
                    survivors.add(new Soldier(i));
                    break;
            }
        }
        // Return the list
        return survivors;
    }
}

