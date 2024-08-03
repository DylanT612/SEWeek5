import java.util.List; 
import java.util.Iterator;
// War zone consisting of a list of zombies and survivors
public class Battlefield {
    private List<Zombie> zombies;
    private List<Survivor> survivors;

    // Constructor
    public Battlefield(List<Zombie> zombies, List<Survivor> survivors) {
        this.zombies = zombies;
        this.survivors = survivors;
    }

    // Battle sim
    public void simulateBattle() {

        // Print how many survivors
        System.out.println("We have " + survivors.size() + " survivors trying to make it to safety (" + countSurvivors(survivors) + ")\n");
        // Print how many zombies
        System.out.println("But there are " + zombies.size() + " zombies waiting for them (" + countZombies(zombies) + ")\n");

        // while there are zombies and survivors
        while (anyAlive(zombies) && anyAlive(survivors)) {
            // Iterate over each survivor
            for (Iterator<Survivor> survivorIterator = survivors.iterator(); survivorIterator.hasNext();) {
                Survivor survivor = survivorIterator.next();
                // Check if each survivor is alive
                if (survivor.isAlive()) {
                    // Iterate over each zombie
                    for (Iterator<Zombie> zombieIterator = zombies.iterator(); zombieIterator.hasNext();) {
                        Zombie zombie = zombieIterator.next();
                        // Check if zombie is alive, then attack zombie
                        if (zombie.isAlive()) {
                            zombie.receiveDamage(survivor.getAttack());
                            // If zombie is dead remove zombie and print kill
                            if (!zombie.isAlive()) {
                                zombieIterator.remove();
                                System.out.println(survivor.getType() + " " + survivor.getId() + " killed " + zombie.getType() + " " + zombie.getId());
                                // Move to next survivor
                                break;
                            }
                        }
                    }
                }
            }
            // Iterate over each zombie
            for (Iterator<Zombie> zombieIterator = zombies.iterator(); zombieIterator.hasNext();) {
                Zombie zombie = zombieIterator.next();
                // If the zombie is alive
                if (zombie.isAlive()) {
                    // Iterate over each survivor
                    for (Iterator<Survivor> survivorIterator = survivors.iterator(); survivorIterator.hasNext();) {
                        Survivor survivor = survivorIterator.next();
                        // Check if survivor is alive, then attack survivor
                        if (survivor.isAlive()) {
                            survivor.receiveDamage(zombie.getAttack());
                            // If survivor is dead remove survivor and print kill
                            if (!survivor.isAlive()) {
                                survivorIterator.remove();
                                System.out.println(zombie.getType() + " " + zombie.getId() + " killed " + survivor.getType() + " " + survivor.getId());
                                // Move to next zombie
                                break;
                            }
                        }
                    }
                }
            }
        }


        // Count how many survivors are alive
        long survivorsAlive = survivors.stream().filter(Survivor::isAlive).count();
        // If survivors beat zombies
        System.out.println();
        if (survivorsAlive > 0) {
            System.out.println("It seems " + survivorsAlive + " have made it to safety.\n");
        // If zombies beat survivors
        } else {
            System.out.println("None of the survivors made it.\n");
        }
    }

    // Get how many survivors there are
    private String countSurvivors(List<? extends Character> characters) {
        // For each type take the characters.stream and filter it by which by getType and take the count
        long scientists = characters.stream().filter(c -> c.getType().equals("Scientist")).count();
        long civilians = characters.stream().filter(c -> c.getType().equals("Civilian")).count();
        long soldiers = characters.stream().filter(c -> c.getType().equals("Soldier")).count();
        // Return the counts of each type
        return scientists + " scientist, " + civilians + " civilian, " + soldiers + " soldiers";
    }

    // Get how many survivors there are
    private String countZombies(List<? extends Character> characters) {
        // For each type take the characters.stream and filter it by which by getType and take the count
        long commonInfected = characters.stream().filter(c -> c.getType().equals("CommonInfected")).count();
        long tanks = characters.stream().filter(c -> c.getType().equals("Tank")).count();
        // Return the counts of each type
        return commonInfected + " common infected, " + tanks + " tanks";
    }

    // method for asking which class had isAlive return true, if at least 1 isAlive return true
    private boolean anyAlive(List<? extends Character> characters) {
        return characters.stream().anyMatch(Character::isAlive);
    }
}
