package Game;

public class Weapon extends  Item {
    protected String name;
    protected int damage;
    protected double range;

    public Weapon(String name, int damage, double range) {
        super(name);
        this.damage = damage;
        this.range = range;
    }


    public boolean hit (BaseCharacter actor, BaseCharacter target) {
        if (!target.isAlive()) {
            System.out.println("Враг уже повержен");
            return false;
        }
        double rangeToTarget =  Math.sqrt(
                Math.pow(actor.getPos_x() - target.getPos_x(), 2) *
                Math.pow(actor.getPos_y() - target.getPos_y(), 2)
        );

        if (rangeToTarget > range) {
            System.out.println("Враг слишком далеко для оружия " + name);
            return false;
        }

        target.getDamage(damage);
        System.out.println("Врагу нанесен урон оружием " + name + " в размере " + damage);
        return true;
    }


    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                '}';
    }
}
