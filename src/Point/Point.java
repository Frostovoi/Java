package Point;

public class Point {
    private double x;
    private double y;

    Point(){
        x = 0;
        y = 0;
    }

    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distance(){
        return Math.sqrt(x*x + y*y);
    }

    public double distanceBetweenPoints(Point point){
        return Math.sqrt(Math.pow(point.getX() - x, 2) + Math.pow(point.getY() - y, 2));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
