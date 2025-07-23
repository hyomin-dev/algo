package com.multi.baekjoon.tmp;

import java.io.*;
import java.util.*;

public class P_2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] array = new int[16];

        array[0] = 2;

        for(int i=1;i<=15;i++){
            array[i] = array[i-1]+array[i-1]-1;
        }

        int n = Integer.parseInt(br.readLine());

        bw.write(array[n]*array[n]+"");

        bw.flush();
        bw.close();
        br.close();

    }
}

/*

idx: 0 1 2 3 4
점:  2 3 5 9 17

다음 idx의 점: 현재 자신의 점 + (현재 자신의 점 -1) --> 현재 점에 사이 사이 마다 점이 추가 됨


* */
