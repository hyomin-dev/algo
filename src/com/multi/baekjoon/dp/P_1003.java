package com.multi.baekjoon.dp;

import java.io.*;
import java.util.*;

public class P_1003 {
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){

            int n = Integer.parseInt(br.readLine());

            if(n==0)
                bw.write("1 0\n");
            else if(n==1)
                bw.write("0 1\n");
            else{
                int[][] dp = new int[n+1][2];
                dp[0][0] = 1;
                dp[0][1] = 0;

                dp[1][0] = 0;
                dp[1][1] = 1;

                for(int i=2;i<=n;i++){
                    dp[i][0] = dp[i-1][0] + dp[i-2][0];
                    dp[i][1] = dp[i-1][1] + dp[i-2][1];
                }

                bw.write(dp[n][0]+" "+dp[n][1]+"\n");
            }

            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
