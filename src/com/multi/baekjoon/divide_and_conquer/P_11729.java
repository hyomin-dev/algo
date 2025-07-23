package com.multi.baekjoon.divide_and_conquer;

import java.io.*;
import java.util.*;

public class P_11729 {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static Stack<Integer> stack3 = new Stack<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 0;
    public static void main(String[] args) throws IOException {


        int n = Integer.parseInt(br.readLine());

        for(int i=n;i>0;i--)
            stack1.push(i);

        if(n%2==0) {
            count++;
            moveStone(n, 1,3, );

        }
        else {
            count++;
            moveStone(1, 2);
        }
    }

    static void moveStone(int n, int from, int dest, int mid) throws IOException{
        if(n==0)
            return;


    }
}
/*

최초 원판 개수가 홀수 --> 3으로 시작

최초 원판 개수가 짝수 --> 2로 시작
* */
