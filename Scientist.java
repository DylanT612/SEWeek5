// Scientist class
public class Scientist extends Survivor{
    public Scientist(Weapon weapon) {
        super(20,2, "Scientist", weapon.getDamage(), weapon);
    }
}