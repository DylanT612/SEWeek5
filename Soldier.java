// Soldier class
public class Soldier extends Survivor{
    public Soldier(Weapon weapon) {
        super(100,10, "Soldier", weapon.getDamage(), weapon);
    }
}