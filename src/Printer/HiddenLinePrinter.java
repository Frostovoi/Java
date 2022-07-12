package Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HiddenLinePrinter extends NumberedLinePrinter{
    private List<Character> hiddenChars;

    public HiddenLinePrinter(int N, List<Character> hiddenChars) {
        super(N);
        this.hiddenChars = hiddenChars;
    }

    private String changeHidden(String line) {
        for (int j = 0; j < line.length(); j++) {
            if (hiddenChars.contains(line.charAt(j)))
                line = line.substring(0, j) + "*" + line.substring(j + 1);
        }
        return line;
    }

    @Override
    public void print(String string) {
        super.print(changeHidden(string));
    }

    @Override
    protected String padFancy(String line, int N) {
        Random random = new Random();
        StringBuilder lineBuilder = new StringBuilder(line);
        while (lineBuilder.length() < N) {
            lineBuilder.append(random.nextInt(10));
        }
        return lineBuilder.toString();
    }
}
