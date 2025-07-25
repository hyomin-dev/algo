package com.multi.baekjoon.dp;

import java.io.*;
import java.util.*;

public class P_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[] array = new long[n+1];
        array[0] = 1;
        array[1] = 1;

        for(int i=2;i<=n;i++)
            array[i] = (array[i-1]%15746 + array[i-2]%15746)%15746;

        bw.write(array[n]+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
