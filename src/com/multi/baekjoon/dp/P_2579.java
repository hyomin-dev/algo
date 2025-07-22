package com.multi.baekjoon.dp;

import java.io.*;
import java.util.*;

public class P_2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];
        int[][] dp = new int[n+1][2];

        for(int i=1;i<=n;i++)
            array[i] = Integer.parseInt(br.readLine());

       if(n==1)
           bw.write(array[1]+"\n");
       else if(n==2)
           bw.write(array[1]+array[2]+"");
       else{
           dp[1][0] = array[1];
           dp[1][1] = 0;

           dp[2][0] = array[2];
           dp[2][1] = array[1]+array[2];

           for(int i=3;i<=n;i++){
               dp[i][0] = Math.max(dp[i-2][0],dp[i-2][1]) + array[i];
               dp[i][1] = dp[i-1][0]+array[i];
           }

           bw.write(Math.max(dp[n][0],dp[n][1])+"");

       }

        bw.flush();
        bw.close();
        br.close();
    }
}

/*

해당 계단에 올라는 경우: 첫 계단 또는 두 번째 계단

첫 계단인 경우: 이전 2번째 칸에서 2계단 넘은 경우 --> max(dp[n-2][0], dp[n-2][1])

두 번째 계단 인 경우: 이전 칸에서 올라온 경우 --> dp[n-1][0]

dp[n] --> max(dp[n][0], dp[n][1]) + array[n]



* */
