package Point;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PointTask {
    public static ArrayList<Point> readFile(String fileName){
        ArrayList<Point> arrayPoints = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                String[] coordinates = line.split(";");
                Point point = new Point(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
                arrayPoints.add(point);
            }
        }
        catch(IOException exc){
            exc.printStackTrace();
        }
        return arrayPoints;
    }

    public static Point farthestPoint(ArrayList<Point> arrayPoints){
        double max = 0;
        Point farthestPoint = null;
        for(Point point : arrayPoints){
            double curDistance = point.distance();
            if (curDistance > max){
                max = curDistance;
                farthestPoint = point;
            }
        }
        return farthestPoint;
    }

    public static ArrayList<Point> closestPoints(ArrayList<Point> arrayPoints){
        ArrayList<Point> closestPoints = new ArrayList<>();

        double min = Double.MAX_VALUE;
        for(int i = 0; i < arrayPoints.size(); i++){
            Point firstPoint = arrayPoints.get(i);
            for(int j = i + 1; j < arrayPoints.size(); j++){
                Point secondPoint = arrayPoints.get(j);
                double curDist = firstPoint.distanceBetweenPoints(secondPoint);
                if (curDist < min){
                    min = curDist;
                    closestPoints.clear();
                    closestPoints.add(firstPoint);
                    closestPoints.add(secondPoint);
                }
            }
        }
        return closestPoints;
    }

    public static void printPoints(ArrayList<Point> arrayPoints){
        for (Point point : arrayPoints){
            System.out.println(point.getX() + " " + point.getY());
        }
    }
    public static void main(String[] args) {
        ArrayList<Point> arrayPoints = readFile("points_input.txt");
        printPoints(arrayPoints);


        Point farthest = farthestPoint(arrayPoints);
        System.out.println("Самая дальняя точка:");
        System.out.println("\t" + farthest.getX() + " " + farthest.getY());


        arrayPoints = closestPoints(arrayPoints);
        System.out.println("Самые близкие точки:");
        System.out.println(
                "\t" + arrayPoints.get(0).getX() + " " + arrayPoints.get(0).getY() +
                "\t\t" + arrayPoints.get(1).getX() + " " + arrayPoints.get(1).getY()
        );

    }
}
