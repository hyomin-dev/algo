package com.multi.baekjoon.divide_and_conquer;

import java.io.*;
import java.util.*;


public class P_2630 {
    static int n;
    static int[][] paper;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        paper = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for(int y=1;y<=n;y++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x=1;x<=n;x++){
                paper[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int s=16;s>=1;s/=2){
            int start = 1;
            int end = s;
            // System.out.println(y+"~"+(y+s-1));
            for(int y=start;y<=16;y+=s){
                for(int x=start;x<=16;x+=s){

                }

            }

        }

    }

    static boolean search(int startY, int endY, int startX, int endX, int value){
        return false;
    }
}

/*
8
0~1, 2~3, 4~5, 6~7

1~2, 3~4, 5~6, 7~8

--> 1부터 시작하도록 함

16이라면
1. 1~16 --> 16/1
2. 1~8, 9~16 --> 16/2
3. 1~4, 5~8, 9~12, 13~16 --> 16/4
4. 1~2, 3~4, 5~6, 7~8, 9~10, 11~12, 13~14, 15~16 --> 16/8
5. 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 --> 16/16

* */