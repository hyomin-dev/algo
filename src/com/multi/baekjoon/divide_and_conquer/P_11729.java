package com.multi.baekjoon.divide_and_conquer;

import java.io.*;
import java.util.*;

public class P_11729 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 0;
    static ArrayList<String> resultList = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        moveStone(n, 1,3, 2 );

        bw.write(count+"\n");
        for(String result: resultList)
            bw.write(result+"\n");

        bw.flush();
        bw.close();
        br.close();

    }

    static void moveStone(int n, int from, int dest, int rest) {
        if(n==0)
            return;
        moveStone(n-1,from,rest,dest);
        resultList.add(from+" "+dest);
        count++;
        moveStone(n-1,rest,dest,from);

    }
}
/*

최초 원판 개수가 홀수 --> 3으로 시작

최초 원판 개수가 짝수 --> 2로 시작

n을 목적지로 옮기기 위해서 --> n-1을 나머지 기둥에 놓는다. --> n을 목적지로 옮긴다. --> n-1을 목적지로 옮긴다.

이 과정을 반복

* */
