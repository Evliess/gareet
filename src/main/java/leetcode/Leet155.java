package leetcode;


import java.util.Map;
import java.util.Stack;

class Node {
    int curr;
    int min;
}

class MinStack {
    private Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        Node node = new Node();
        if (stack.isEmpty()) {
            node.curr = val;
            node.min = val;
            stack.push(node);
        } else {
            int currMin = stack.peek().min;
            currMin = Math.min(currMin, val);
            node.curr = val;
            node.min = currMin;
            stack.push(node);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().curr;
    }

    public int getMin() {
        return stack.peek().min;
    }
}

public class Leet155 {

}
