package com.multi.baekjoon.divide_and_conquer;

import java.io.*;
import java.util.*;

public class P_2740 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrixA = new int[n][m];

        for(int y=0;y<n;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0;x<m;x++){
                matrixA[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] matrixB = new int[m][k];
        for(int y=0;y<m;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0;x<k;x++){
                matrixB[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[n][k];

        for(int y=0;y<n;y++){
            for(int bx=0;bx<k;bx++){
                for(int x=0;x<m;x++){
                    result[y][bx] += matrixA[y][x] *matrixB[x][bx];
                }
            }
        }

        for(int y=0;y<n;y++){
            for(int x=0;x<k;x++){
                bw.write(result[y][x]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
