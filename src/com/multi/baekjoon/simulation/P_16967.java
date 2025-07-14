package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_16967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] oriMatrix = new int[h][w];
        int[][] matrix = new int[h+x][w+y];

        for(int r=0;r<h+x;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<w+y;c++){
                matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 배열 B에서 배열 A크기 만큼만 추출
        for(int r=0;r<h;r++){
            for(int c=0;c<w;c++)
                oriMatrix[r][c] = matrix[r][c];
        }

        // B(i,j) - A(i-x, j-y) = A(i,j)

        for(int r=x;r<h;r++){
            for(int c=y;c<w;c++){
                oriMatrix[r][c] -=oriMatrix[r-x][c-y];
            }
        }

        for(int r=0;r<h;r++){
            for(int c=0;c<w;c++){
                bw.write(oriMatrix[r][c]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
/*

배열 A: H X W
배열 B: (H+X) X (W+Y) --> 배열 A를 아래로 X칸, 오른쪽으로 Y칸 이동 --> 수가 겹치면 수가 합쳐진다.

이동한 부분의 top left 좌표: (x,y)


* */

