package StackCalculator;

import StackCalculator.Exceptions.*;

import java.util.List;

public class Utils {

    public static boolean isDouble(String arg) {
        try {
            Double.parseDouble(arg);
            return true;
        }
        catch (Exception exc) {
            return false;
        }
    }

    public static void operatorCheck(List<String> args, Context context) {
        if (args.size() > 1)
            throw new IncorrectCountElementsException();
        if (context.stack.isEmpty())
            throw new EmptyStackException();
        if (args.size() == 0) {
            if (context.stack.size() < 2)
                throw new StackException();
        }
    }

    public static void argumentOperation(List<String> args, String operator,Context context) {
        double firstArg,secondArg;
        if (args.size() == 1) {
            if (!Utils.isDouble(args.get(0)))
                throw new IncorrectArgumentException();
            firstArg = context.stack.pop();
            secondArg = Double.parseDouble(args.get(0));
        }
        else {
            firstArg = context.stack.pop();
            secondArg = context.stack.pop();
        }
        switch(operator){
            case ("+") :
                context.stack.push(firstArg + secondArg);
                break;
            case("-") :
                context.stack.push(firstArg - secondArg);
                break;
            case("/") :
                if (secondArg == 0)
                    throw new ZeroDivisionException();
                context.stack.push(firstArg / secondArg);
                break;
            case("*") :
                context.stack.push(firstArg * secondArg);
                break;
        }
    }
}
