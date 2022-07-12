package StackCalculator.Commands;

import StackCalculator.Context;
import StackCalculator.Exceptions.EmptyStackException;

import java.util.List;

public class PopCommand implements IBaseCommand {

    @Override
    public void execute(List<String> args, Context context) {
        if (args.size() > 0)
            throw new IllegalArgumentException();
        if (context.stack.isEmpty())
            throw new EmptyStackException();
        context.stack.pop();
    }
}
