package com.company;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {

    public static void isBalanced() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    System.out.print("0");
                    return;
                } else {
                    if(stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }
        }
        String output = stack.isEmpty() ? "1" : "0";
        System.out.println(output);
    }
    public static void main(String[] args) {
        BalancedParenthesis bp = new BalancedParenthesis();
        bp.isBalanced();
    }
}
