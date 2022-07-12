package Printer;

import java.util.ArrayList;
import java.util.Comparator;

public class LinePrinter {
    private int N;
    protected ArrayList <String> lines;

    LinePrinter(int N) {
        this.N = N;
    }

    protected void fillLines(String string) {
        lines = new ArrayList<>();
        int i = 0;
        while (i + N < string.length()) {
            String line = string.substring(i, i + N);
            lines.add(line);
            i += N;
        }
        lines.add(string.substring(i));
    }

    public void print(String string){
        fillLines(string);
        for(String line : lines){
            System.out.println(line);
        }
    }

    private int findMax(ArrayList<String> strings) {
//        int max = -1;
//        for (var string : strings){
//            if (string.length() > max)
//                max = string.length();
//        }
        return strings.stream().max(Comparator.comparing(String::length)).get().length();
    }

    protected String padFancy(String line, int N) {
//        StringBuilder lineBuilder = new StringBuilder(line);
//        while (lineBuilder.length() < N) {
//            lineBuilder.append("#");
//        }
//        return lineBuilder.toString();
        return line + "#".repeat(N - line.length());
   }

   public void fancyPrint(ArrayList<String> strings) {
        int max = findMax(strings);
        for (var string : strings) {
            System.out.println(padFancy(string, max));
        }
   }
}
