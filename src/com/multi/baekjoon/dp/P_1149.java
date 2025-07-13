package com.multi.baekjoon.dp;


import java.io.*;
import java.util.StringTokenizer;

public class P_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n][3];
        for(int y=0;y<n;y++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x=0;x<3;x++)
                cost[y][x] = Integer.parseInt(st.nextToken());
        }

        int[][] minCost = new int[n][3];

        minCost[0][0] = cost[0][0]; // 1번 집 R로 칠하는 비용
        minCost[0][1] = cost[0][1]; // 2번 집 G로 칠하는 비용
        minCost[0][2] = cost[0][2]; // 3번 집 B로 칠하는 비용


        // 전 집과 색이 다르면 가능

        for(int h=1;h<n;h++){ //house
            for(int c=0;c<3;c++) { // color

                if(c==0){ // h번 째 집을 R로 칠해야 할 경우, h-1번 째 집은 G또는 B여야 됨 --> 이 중 최솟 값을 선택
                    int minValue = Math.min(minCost[h-1][1],minCost[h-1][2]);
                    minCost[h][0] = minValue + cost[h][0];

                }else if(c==1){ // h번 째 집을 G로 칠해야 할 경우, h-1번 째 집은 R또는 B여야 됨 --> 이 중 최솟 값을 선택
                    int minValue = Math.min(minCost[h-1][0],minCost[h-1][2]);
                    minCost[h][1] = minValue + cost[h][1];

                }else{ // h번 째 집을 B로 칠해야 할 경우, h-1번 째 집은 R또는 G여야 됨 --> 이 중 최솟 값을 선택
                    int minValue = Math.min(minCost[h-1][0],minCost[h-1][1]);
                    minCost[h][2] = minValue + cost[h][2];
                }
            }
        }

        int result = Math.min(minCost[n-1][0],Math.min(minCost[n-1][1],minCost[n-1][2]));

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }
}

/*
2 <= n <= 1000

집 색: 빨강, 초록, 파랑 중 하나

구해야 하는 것: 규칙을 만족하면서, 모든 집을 칠하는 비용의 최솟값

규칙1: 1번과 2번 집의 색은 다름
규칙2: N-1집과 N번 집의 색은 다름
규칙3: i번째 집색은 i-1과 i+1번과 다름,  2 <= i <= n-1 --> i집색 != i-1 집색, i집색 !=i+1 집색
*
* */
