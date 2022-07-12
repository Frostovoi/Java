package StackCalculator.Commands;

import StackCalculator.Context;
import StackCalculator.Utils;

import java.util.EmptyStackException;
import java.util.List;

public class SqrtCommand implements IBaseCommand {

    @Override
    public void execute(List<String> args, Context context) {
        if (context.stack.isEmpty())
            throw new EmptyStackException();
        context.stack.push(Math.sqrt(context.stack.pop()));
    }
}
