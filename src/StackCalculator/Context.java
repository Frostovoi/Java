package StackCalculator;

import java.util.HashMap;
import java.util.Stack;

public class Context {
    public Stack<Double> stack;
    public HashMap<String,Double> map;

    public Context() {
        stack = new Stack<>();
        map = new HashMap<>();
    }
}
