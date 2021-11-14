package com.company;

import java.util.*;


/**
 * 1 - push
 * 2 - pop
 * 3 - return the max
 * */

public class Main {
    public List<Integer> getMax(List<String> operations) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> mainStack = new Stack();
        Stack<Integer> maxStack = new Stack();
        for(String o: operations) {
            String[] s = o.split(" ", 0);
            if(s.length > 1) {
                mainStack.push(Integer.parseInt(s[1]));
                if(maxStack.isEmpty()) {
                    maxStack.push(Integer.parseInt(s[1]));
                } else {
                    Integer maxSoFar = maxStack.peek();
                    if (maxSoFar > Integer.parseInt(s[1])) {
                        maxStack.push(maxSoFar);
                    } else {
                        maxStack.push(Integer.parseInt(s[1]));
                    }
                }
            } else {
                if(s[0] == "2") {
                    mainStack.pop();
                    maxStack.pop();
                } else if(s[0] == "3") {
                    result.add(maxStack.peek());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();
	    System.out.println("Hello Mac!");
        List<String> op = new ArrayList();
        op.add("1 97");
        op.add("2");
        op.add("1 20");
        op.add("2");
        op.add("1 26");
        op.add("1 20");
        op.add("2");
        op.add("3");
        op.add("1 91");
        op.add("3");
        List<Integer> max = m.getMax(op);
        for(Integer i : max) {
//            System.out.print(i);
        }


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
//        System.out.println(eq.getBalancedHeight(h1, h2, h3));

//        RotateArray rt = new RotateArray();
//        List<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(2);
//        arr.add(3);
//        arr.add(4);
//        arr.add(5);
//
//        List<Integer> rotatedArray = rt.rotateArray(arr, 4);
//        for(Integer i : rotatedArray) {
//            System.out.print(i);
//        }

        CheckAnagram ch = new CheckAnagram();

        String s1 = "abab";
        String s2 = "baba";
        System.out.println(ch.isAnagram(s1, s2));

        StringCompression sc = new StringCompression();
        String str = "aaabbcddsdswwqeeekkkkttiioooookkkkkksjffjjjjgnnxxxdfd";
        System.out.println(sc.compress(str));

//        StringSubsequence sq = new StringSubsequence();
//        sq.powerSet("abcd", -1, "");
//        System.out.println();

        SherlockAnagram sherlock = new SherlockAnagram();
        System.out.println(sherlock.sherlockAndAnagram("mom"));
    }
}
