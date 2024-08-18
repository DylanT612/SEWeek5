// Civilian class
public class Civilian extends Survivor{
    public Civilian(Weapon weapon) {
        super(50,5, "Civilian", weapon.getDamage(), weapon);
    }
}