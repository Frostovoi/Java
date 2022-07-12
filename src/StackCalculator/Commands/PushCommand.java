package StackCalculator.Commands;

import StackCalculator.Context;
import StackCalculator.Exceptions.IncorrectCountElementsException;
import StackCalculator.Exceptions.UndefinedArgumentException;
import StackCalculator.Utils;

import java.util.List;

public class PushCommand implements IBaseCommand {

    @Override
    public void execute(List<String> args, Context context) {
        if (args.size() != 1)
            throw new IncorrectCountElementsException();
        if (Utils.isDouble(args.get(0))){
            context.stack.push(Double.parseDouble(args.get(0)));
        }
        else {
            if (context.map.containsKey(args.get(0))) {
                context.stack.push(context.map.get(args.get(0)));
            }
            else
                throw new UndefinedArgumentException();
        }
    }
}
