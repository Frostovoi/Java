package Polymorfizm;

public class Main {
    public static void main(String[] args) {
        Picture picture = new Picture();
        Circle circle = new Circle(10,20,5);
        Rectangle rectangle = new Rectangle(7, 7, 20, 30);

        picture.add(circle);
        picture.add(rectangle);

        double s = picture.calcArea();
        System.out.println(s);

        picture.show();
    }
}
