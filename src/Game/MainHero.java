package Game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MainHero extends BaseCharacter {
    protected String name;
    protected Weapon weapon;
    private ArrayList<Item> inventory = new ArrayList<>();

    public MainHero(double pos_x, double pos_y, String name, int hp) {
        super(pos_x, pos_y, hp);
        this.name = name;
    }

    public boolean hit (BaseCharacter target) {
        if (weapon == null) {
            System.out.println("Я безоружен");
            return false;
        }
        if (!(target instanceof BaseEnemy)) {
            System.out.println("Могу ударить только Врага");
            return false;
        }
        weapon.hit(this, target);
        return true;
    }

    public boolean addWeapon(Item weapon) {
        if (!(weapon instanceof Weapon)) {
            System.out.println("Это не оружие");
            return false;
        }
        inventory.add(weapon);
        if (inventory.size() == 1)
            this.weapon = (Weapon) weapon;
        System.out.println("Подобрал " + weapon.name);
        return true;
    }

    public boolean nextWeapon() {
        if (weapon == null) {
            System.out.println("Я безоружен");
            return false;
        }

        LinkedList <Item> weapons =
                inventory.stream().
                filter(t -> t instanceof Weapon).
                collect(Collectors.toCollection(LinkedList::new));

        if (weapons.size() == 1) {
            System.out.println("У меня только одно оружие");
            return false;
        }

        if (weapons.getLast() == weapon) {
            weapon = (Weapon) weapons.getFirst();
        }
        else {
            weapon = (Weapon) weapons.get(weapons.indexOf(weapon) + 1);
        }
        System.out.println("Сменил оружие на " + weapon.name);
        return true;
    }

    public void heal(int amount) {
        final int maxHp = 200;
        if (hp + amount > maxHp)
            hp = maxHp;
        else
            hp += amount;
        System.out.println("Полечился, теперь здоровья " + hp);
    }
}
