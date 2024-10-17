package practice.dp;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> s;
    private Stack<Integer> t;

    public MinStack() {
        s = new Stack<>();
        t = new Stack<>();
    }

    public void push(int x) {
        s.push(x);
        int min = t.isEmpty() || x < t.peek() ? x : t.peek();
        t.push(min);
    }

    public void pop() {
        s.pop();
        t.pop();
    }

    public int getTop() {
        return s.peek();
    }

    public int getMin() {
        return t.peek();
    }

}
