package com.multi.baekjoon.dp;


import java.io.*;

public class P_2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] array = new long[n+1];
        array[0] = 0;
        if(n>=1)
            array[1] = 1;


        for(int i=2;i<=n;i++)
            array[i] = array[i-1] + array[i-2];

        bw.write(String.valueOf(array[n]));
        bw.flush();
        bw.close();
        br.close();

    }
}
