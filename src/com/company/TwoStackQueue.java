package com.company;

import java.util.Stack;

public class TwoStackQueue<T> {
    Stack<T> st1 = new Stack<T>();
    Stack<T> st2 = new Stack<T>();

    public T dequeue() {
        if(st2.isEmpty()) {
            while(!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }

    public void enqueue(T n) {
        st1.push(n);
    }

    public T peek() {
        if(st2.isEmpty()) {
            while(!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }


    public static void main(String[] args) {
        TwoStackQueue tq = new TwoStackQueue();
        tq.enqueue(1);
        tq.enqueue(2);
        System.out.println(tq.dequeue());
        System.out.println(tq.peek());
    }
}
