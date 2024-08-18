import java.util.Random;

// Each weapon has a name, damage, and accuracy level
public class Weapon {
    private String name;
    private int damage;
    private int accuracy;

    // Constructor
    public Weapon(String name, int damage, int accuracy) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    // Get damage
    public int getDamage() {
        return damage;
    }

    // Weapon hits target
    public boolean hitsTarget() {
        Random random = new Random();
        // If acc level is 75 it hits 75 out of 100 times
        // Takes random int and if int generated is higher than accuracy returns false else true
        return random.nextInt(100) < accuracy;
    }

    // toString returns weapon name
    @Override
    public String toString() {
        return name;
    }
}

