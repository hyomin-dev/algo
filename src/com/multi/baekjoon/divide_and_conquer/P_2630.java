package com.multi.baekjoon.divide_and_conquer;

import java.io.*;
import java.util.*;


public class P_2630 {
    static int[][] paper;
    static int white = 0, blue = 0; // white: 0, blue: 1
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for(int y=0;y<n;y++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x=0;x<n;x++){
                paper[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        search(n,0,0);

        bw.write(String.valueOf(white));
        bw.newLine();
        bw.write(String.valueOf(blue));

        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int n, int startX, int startY){
        for(int y=startY;y<startY+n;y++){
            for(int x=startX;x<startX+n;x++){
                if(paper[y][x]!=paper[startY][startX]){
                    int halfN = n/2;
                    search(halfN,startX, startY);
                    search(halfN,startX+halfN,startY);
                    search(halfN,startX,startY+halfN);
                    search(halfN,startX+halfN,startY+halfN);
                    return;
                }
            }
        }

        if(paper[startY][startX]==0)
            white++;
        else
            blue++;

    }
}
