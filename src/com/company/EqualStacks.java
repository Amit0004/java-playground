package com.company;
import java.util.*;

public class EqualStacks {

    public Integer getBalancedHeight(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> s1 = new Stack<Integer>(); //First stack of cylinders
        Stack<Integer> s2 = new Stack<Integer>(); //Second stack of cylinders
        Stack<Integer> s3 = new Stack<Integer>(); //Third stack of cylinders

        int ht1 = 0; //Height of the first stack
        int ht2 = 0; //Height of the second stack
        int ht3 = 0; //Height of the third stack

        int minStack; //The stack with the smallest height

        //Initialize the stacks and their heights
        for(int i = h1.size()-1; i >= 0 ; i--){
            s1.push(h1.get(i));
            ht1 += h1.get(i);
        }

        for(int i = h2.size()-1; i >= 0 ; i--){
            s2.push(h2.get(i));
            ht2 += h2.get(i);
        }

        for(int i = h3.size()-1; i >= 0 ; i--){
            s3.push(h3.get(i));
            ht3 += h3.get(i);
        }

        minStack = Math.min(ht1,Math.min(ht2,ht3)); //Initialize minStack with the minimum height

        //Heights are not all equal enter the while loop
        while(ht1 != ht2 || ht1 != ht3) {
            //Remove cylinders from stack 1 until your height is <= the smallest
            while(ht1 > minStack){
                ht1 -= s1.pop();
            }
            minStack = Math.min(ht1,Math.min(ht2,ht3)); //Recalculate min

            //Remove cylinders from stack 2 until your height is <= the smallest
            while(ht2 > minStack){
                ht2 -= s2.pop();
            }
            minStack = Math.min(ht1,Math.min(ht2,ht3)); //Recalculate min

            //Remove cylinders from stack 3 until your height is <= the smallest
            while(ht3 > minStack){
                ht3 -= s3.pop();
            }
            minStack = Math.min(ht1,Math.min(ht2,ht3)); //Recalculate min

        }

        return minStack;
//        return result;
    }
    public static void main(String[] args) {
        List<Integer> h1 = new ArrayList<>();
        List<Integer> h2 = new ArrayList<>();
        List<Integer> h3 = new ArrayList<>();

        h1.add(3);
        h1.add(2);
        h1.add(1);
        h1.add(1);
        h1.add(1);

        h2.add(4);
        h2.add(3);
        h2.add(2);

        h3.add(1);
        h3.add(1);
        h3.add(4);
        h3.add(1);

        EqualStacks eq = new EqualStacks();
        System.out.println(eq.getBalancedHeight(h1, h2, h3));
    }
}
