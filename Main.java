import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

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
            Weapon weapon = getRandomWeapon();
            int choice = random.nextInt(3);
            switch (choice) {
                case 0:
                    survivors.add(new Scientist(weapon));
                    break;
                case 1:
                    survivors.add(new Civilian(weapon));
                    break;
                case 2:
                    survivors.add(new Soldier(weapon));
                    break;
            }
        }
        // Return the list
        return survivors;
    }

    // Generate Weapons
    private static List<Weapon> weaponsCache = Arrays.asList(
            // Each weapon has a damage and accuracy
            new Weapon("Shotgun", 25, 75),
            new Weapon("Submachine Gun", 50, 40),
            new Weapon("Assault Rifle", 35, 60),
            new Weapon("Pistol", 20, 90),
            new Weapon("Axe", 15, 95),
            new Weapon("Crowbar", 7, 95),
            new Weapon("Frying Pan", 5, 100)
    );

    // Pick random weapon from the cache
    private static Weapon getRandomWeapon() {
        Random random = new Random();
        return weaponsCache.get(random.nextInt(weaponsCache.size()));
    }

}

