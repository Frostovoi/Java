package Game;

public class BaseEnemy extends BaseCharacter {
    private Weapon weapon;

    public BaseEnemy(double pos_x, double pos_y, Weapon weapon, int hp) {
        super(pos_x, pos_y, hp);
        this.weapon = weapon;
    }

    public boolean hit (BaseCharacter target) {
        if (!(target instanceof MainHero)) {
            System.out.println("Могу ударить только Главного героя");
            return false;
        }
        weapon.hit(this, target);
        return true;

    }

    @Override
    public String toString() {
        return "BaseEnemy{" +
                "weapon=" + weapon.name +
                ", pos_x=" + pos_x +
                ", pos_y=" + pos_y +
                '}';
    }
}
