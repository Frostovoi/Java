package StackCalculator.Commands;

import StackCalculator.Context;
import StackCalculator.Exceptions.IncorrectCountElementsException;
import StackCalculator.Exceptions.StackException;
import StackCalculator.Utils;

import java.util.List;

public class DefineCommand implements IBaseCommand {

    @Override
    public void execute(List<String> args, Context context) {
        if (args.size() != 2)
            throw new IncorrectCountElementsException();
        if (Utils.isDouble(args.get(0)))
            throw new StackException();
        context.map.put(args.get(0), Double.parseDouble(args.get(1)));
    }
}
