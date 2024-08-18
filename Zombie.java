// Zombie class used for Common Infected and Tank
public abstract class Zombie extends Character{
    public Zombie(int health, int attack, String type, int id) {
        super(health, attack, type, id);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.getId();
    }
}
