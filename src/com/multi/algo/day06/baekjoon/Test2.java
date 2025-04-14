package com.multi.algo.day06.baekjoon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n=6;

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++)
            queue.offer(i);

        while(queue.size()!=1){
            queue.remove();
            queue.offer(queue.remove());

        }

        System.out.println(queue.poll());
    }
}
