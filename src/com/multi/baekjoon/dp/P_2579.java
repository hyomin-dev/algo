package com.multi.baekjoon.dp;

import java.io.*;
import java.util.*;

public class P_2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++)
            array[i] = Integer.parseInt(br.readLine());

        int count = 1;

        dp[0] = 0;
        dp[1] = array[1];

        // 제한이 없는 경우: dp[i] = max(dp[i-1], dp[i-2])+array[i]

        for(int i=2;i<=n;i++){

            if(count==2){
                dp[i] = dp[i-2]+array[i];
                count = 1;
            }else if(dp[i-1]>dp[i-2]){

                dp[i] = dp[i-1]+array[i];
                count++;
            }else{ // dp[i-1] <= dp[i-2]

                dp[i] = dp[i-2] +array[i];
                count = 1;
            }
        }

        bw.write(dp[n]+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
