// Character creation with its own health and attack
public abstract class Character {
    protected int health;
    protected int attack;
    protected String type;
    protected int id;

    // Constructor
    public Character(int health, int attack, String type, int id) {
        this.health = health;
        this.attack = attack;
        this.type = type;
        this.id = id;
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
    // Get a characters type
    public String getType() {
        return this.type;
    }
    // Get a characters ID
    public int getId() {
        return this.id;
    }
}
