package com.multi.baekjoon.dp;

import java.io.*;
import java.util.*;

public class P_9465 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){

            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[3][n+1]; // 1행 1열부터 시작하기 위함
            for(int y=1;y<=2;y++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int x=1;x<=n;x++){
                    matrix[y][x] = Integer.parseInt(st.nextToken());
                }
            }
            t--;
        }



    }
}
/*
* n=1
* matrix[1][1]과 matrix[2][1] 중 큰 것
*
* n=2
* dp[1][1]+matrix[2][2]과 dp[2][1]+matrix[1][2] 중 큰 것
*
* n=3
* dp[2][2]
* */
