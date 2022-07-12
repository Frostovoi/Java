package Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    static void fillList(ArrayList<Rectangle> rectangles, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int w = random.nextInt(10) + 1;
            int h = random.nextInt(10) + 1;

            Rectangle rectangle = new Rectangle(w, h);
            rectangles.add(rectangle);
        }
    }

    static void printList(ArrayList<Rectangle> rectangles) {
        for(Rectangle rect : rectangles) {
            //System.out.println(rect);
            System.out.println("W = " + rect.getWidth() + ", H = " + rect.getHeight());
        }
    }

    static Rectangle findMax(ArrayList<Rectangle> rectangles) {
        Rectangle max = rectangles.get(0);
        for(Rectangle rect : rectangles ) {
            if (rect.calcArea() > max.calcArea()) {
                max = rect;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        fillList(rectangles, 10);
	    printList(rectangles);

        Rectangle max = findMax(rectangles);
        System.out.println("Самый большой " + max.calcArea());
    }
}
