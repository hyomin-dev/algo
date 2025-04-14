package com.multi.algo.day06.b_stack;


import java.util.Stack;

public class A_Strack {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<String>();
//stack == 누적하다, 쌓다, 적재
        stack.add("홍길동");
        stack.add("김길동");
        stack.add("송길동");
        stack.push("정길동");
        System.out.println(stack);
        System.out.println(stack.get(0));
        System.out.println(stack.contains("홍길동"));
        System.out.println(stack.peek());
        System.out.println(stack);
        stack.pop();
        System.out.println(stack.empty());
        System.out.println(stack);
    }
}
