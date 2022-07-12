package Game;

import java.util.ArrayList;
import java.util.Arrays;

public class BaseCharacter {
    protected double pos_x;
    protected double pos_y;
    protected int hp;

    public BaseCharacter(double pos_x, double pos_y, int hp) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.hp = hp;
    }


    public void move(double delta_x, double delta_y) {
        pos_x += delta_x;
        pos_y += delta_y;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void getDamage(int amount) {
        hp -= amount;
    }


    public double getPos_x() {
        return pos_x;
    }

    public double getPos_y() {
        return pos_y;
    }


}
