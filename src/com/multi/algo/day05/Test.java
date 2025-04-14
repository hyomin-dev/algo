package com.multi.algo.day05;


import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        //["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]
        System.out.println(test.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));

    }
    public int solution(int[] ingredient) {

        //햄버거 포장하는 일
        // 순서: 빵 야채 고기 빵 순서대로 쌓인 햄버거만 포장
        // 빵: 1, 야채: 2, 고기: 3
        // 1 2 3 1

        //
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = null;
        for (int i = ingredient.length-1; i >=0; i--)
            stack.push(ingredient[i]);
        int[] arr = new int[]{1,2,3,1};
        int count=3;




        return answer;
    }
}
