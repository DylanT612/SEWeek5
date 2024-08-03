import java.util.List;
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
        // while there are zombies and survivors
        while (anyAlive(zombies) && anyAlive(survivors)) {
            // If survivor is alive and zombie is alive, survivor attacks zombie
            for (Survivor survivor : survivors) {
                if (survivor.isAlive()) {
                    for (Zombie zombie : zombies) {
                        if (zombie.isAlive()) {
                            zombie.receiveDamage(survivor.attack);
                            // If zombie dies
                            if (!zombie.isAlive()) {
                                break;
                            }
                        }
                    }
                }
            }
            // If zombie is alive and survivor is alive, zombie attacks survivor
            for (Zombie zombie : zombies) {
                if (zombie.isAlive()) {
                    for (Survivor survivor : survivors) {
                        if (survivor.isAlive()) {
                            survivor.receiveDamage(zombie.attack);
                            // If survivor dies
                            if (!survivor.isAlive()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        // Count how many survivors are alive
        long survivorsAlive = survivors.stream().filter(Survivor::isAlive).count();
        // Print how many survivors
        System.out.println("We have " + survivors.size() + " survivors trying to make it to safety.\n");
        // Print how many zombies
        System.out.println("But there are " + zombies.size() + " zombies waiting for them.\n");
        // If survivors beat zombies
        if (survivorsAlive > 0) {
            System.out.println("It seems " + survivorsAlive + " have made it to safety.\n");
        // If zombies beat survivors
        } else {
            System.out.println("It seems they could not defeat the zombie hoard.\n");
        }
    }

    // method for asking which class had isAlive return true, if at least 1 isAlive return true
    private boolean anyAlive(List<? extends Character> characters) {
        return characters.stream().anyMatch(Character::isAlive);
    }
}
