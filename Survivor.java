// Survivor class used for Scientist, Civilian, and Soldier
public abstract class Survivor extends Character{
    private Weapon weapon;
    public Survivor(int health, int attack, String type, int id, Weapon weapon) {
        super(health, attack, type, id);
        this.weapon = weapon;
    }
    // Gets the weapon
    public Weapon getWeapon() {
        return weapon;
    }

    // Gets the attack
    @Override
    public int getAttack() {
        // Checks if weapon hit the target if true gets the damage if false return 0 damage
        return weapon.hitsTarget() ? weapon.getDamage() : 0;
    }

    // toString to shorten print command
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.getId() + " with " + weapon.toString();
    }

}
