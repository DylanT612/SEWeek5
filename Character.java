// Character creation with its own health and attack
public abstract class Character {
    protected int health;
    protected int attack;

    // Constructor
    public Character(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    // Check if still alive(any remaining health)
    public boolean isAlive() {
        return this.health > 0;
    }

    // When taking damage
    public void receiveDamage(int damage) {
        this.health -= damage;
    }

    // Get a characters attack
    public int getAttack() {
        return this.attack;
    }
}
