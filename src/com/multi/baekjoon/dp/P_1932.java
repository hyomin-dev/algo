package com.multi.baekjoon.dp;


import java.io.*;
import java.util.*;

public class P_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n==1){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int result = Integer.parseInt(st.nextToken());
            bw.write(result+"");
        }else{
            int[][] array = new int[n+1][n+1];

            for(int i=1;i<=n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1;j<=i;j++)
                    array[i][j] = Integer.parseInt(st.nextToken());
            }

            int[][] dpTable = new int[n+1][n+1];
            dpTable[1][1] = array[1][1];

            for(int i=2;i<=n;i++){
                dpTable[i][1] = dpTable[i-1][1] +array[i][1];
                for(int j=2;j<=i;j++){
                    dpTable[i][j] = Math.max(dpTable[i-1][j-1], dpTable[i-1][j]) + array[i][j];
                }
            }

            int result = Integer.MIN_VALUE;

            for(int i=1;i<=n;i++){
                if(result<dpTable[n][i])
                    result = dpTable[n][i];
            }

            bw.write(result+"");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
