package Printer;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String string = "Meantime we shall express our darker purpose.";
        LinePrinter printer = new LinePrinter(11);
        printer.print(string);
        System.out.println();

        printer = new LinePrinter(5);
        printer.print(string);
        System.out.println();

        NumberedLinePrinter linePrinter = new NumberedLinePrinter(8);
        linePrinter.print(string);
        System.out.println();

        ArrayList<Character> hiddenChars = new ArrayList<>(Arrays.asList('e', 'o', 'a', 'p', 't'));
        HiddenLinePrinter hiddenLinePrinter = new HiddenLinePrinter(8,hiddenChars);
        hiddenLinePrinter.print(string);
        System.out.println();


        ArrayList<String> strings = new ArrayList<>(Arrays.asList("sdfsd", "asd dde", "sdf asd f", ",. kd "));
        printer.fancyPrint(strings);
        System.out.println();
        hiddenLinePrinter.fancyPrint(strings);


    }
}
