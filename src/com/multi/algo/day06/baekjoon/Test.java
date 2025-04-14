package com.multi.algo.day06.baekjoon;


import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.next());
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<num;i++){
            String str = sc.next();
            if(str.contains("push")){
                int value = Integer.valueOf(sc.next());
                stack.push(value);
            }else if(str.contains("top")){
                if(stack.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(stack.peek());
            }else if(str.contains("size")){
                System.out.println(stack.size());
            }else if(str.contains("empty")){
                if(stack.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }else if(str.contains("pop")) {
                if (stack.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(stack.pop());
            }
        }
        sc.close();
    }
}
