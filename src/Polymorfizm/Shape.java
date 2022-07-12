package Polymorfizm;

public abstract class Shape {
    private int x;
    private int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract double calcArea();

    public String getInfo(){
        return "x " + x + ", y = " + y;
    }
}
