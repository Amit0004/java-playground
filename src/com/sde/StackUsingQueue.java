package com.sde;

import java.util.Stack;


/**
 * Link: https://leetcode.com/problems/implement-queue-using-stacks/
 * Level: medium
 */
public class StackUsingQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    public StackUsingQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        while(!input.isEmpty()) {
            output.push(input.pop());
        }
        int last = output.pop();

        while(!output.isEmpty()) {
            input.push(output.pop());
        }
        return last;
    }

    public int peek() {
        while(!input.isEmpty()){
            output.push(input.pop());
        }

        int firstElement = output.peek();

        while(!output.isEmpty()) {
            input.push(output.pop());
        }

        return firstElement;
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
