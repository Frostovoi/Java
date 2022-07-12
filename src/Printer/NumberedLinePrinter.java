package Printer;

public class NumberedLinePrinter extends LinePrinter{

    NumberedLinePrinter(int N) {
        super(N);
    }

    @Override
    public void print(String string) {
        fillLines(string);
        int i = 1;
        for (var line : lines) {
            System.out.println(i++ + "." + line);
        }
    }
}
