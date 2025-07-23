package com.multi.baekjoon.tmp;

import java.io.*;
import java.util.*;

public class P_24723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array = new int[6];
        array[1] = 2;
        for(int i=2;i<=5;i++)
            array[i] = array[i-1]*2;

        int n = Integer.parseInt(br.readLine());
        bw.write(array[n]+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
