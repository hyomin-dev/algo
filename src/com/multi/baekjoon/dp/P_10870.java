package com.multi.baekjoon.dp;


import java.io.*;

public class P_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(fibo(n)));
        bw.flush();
        bw.close();
        br.close();

    }

    static int fibo(int n){
        if(n<=1)
            return n;
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        for(int i=2;i<=n;i++)
            array[i] = array[i-1] + array[i-2];

        return array[n];
    }
}
