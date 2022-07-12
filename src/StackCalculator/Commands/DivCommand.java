package StackCalculator.Commands;

import StackCalculator.Context;
import StackCalculator.Utils;

import java.util.List;

public class DivCommand implements IBaseCommand {
    @Override
    public void execute(List<String> args, Context context) {
        Utils.operatorCheck(args,context);
        Utils.argumentOperation(args, "/", context);
    }
}
