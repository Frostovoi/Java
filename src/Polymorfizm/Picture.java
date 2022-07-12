package Polymorfizm;

import java.util.ArrayList;

public class Picture {
    private ArrayList<Shape> shapes = new ArrayList<>();

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public double calcArea() {
        double s = 0;
        for(Shape shape : shapes) {
            s += shape.calcArea();
        }
        return s;
    }

    public void show() {
        for(Shape shape : shapes) {
            System.out.println(shape.getInfo());
        }
    }
}
