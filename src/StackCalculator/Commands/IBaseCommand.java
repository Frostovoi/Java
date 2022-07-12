package StackCalculator.Commands;

import StackCalculator.Context;

import java.util.List;

public interface IBaseCommand {
    void execute(List<String> args, Context context);
}
