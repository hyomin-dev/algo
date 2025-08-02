package com.multi.baekjoon.divide_and_conquer;

import java.io.*;
import java.util.*;

public class P_1780 {
    static int[][] paper;
    static int zero = 0, plus = 0, minus = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        for(int y=0;y<n;y++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x=0;x<n;x++)
                paper[y][x] = Integer.parseInt(st.nextToken());
        }

        search(n,0,0);

        bw.write(minus+"\n");
        bw.write(zero+"\n");
        bw.write(plus+"");

        bw.flush();
        bw.close();
        br.close();
    }

    static void search(int n, int startX, int startY){

        for(int y=startY;y<startY+n;y++){
            for(int x=startX;x<startX+n;x++){
                if(paper[y][x]!=paper[startY][startX]){
                    int nOverThree = n/3;
                    for(int yy=startY;yy<=startY+2*nOverThree;yy+=nOverThree){
                        for(int xx=startX;xx<=startX+2*nOverThree;xx+=nOverThree)
                            search(nOverThree,xx,yy);
                    }
                    return;
                }
            }
        }

        if(paper[startY][startX]==-1)
            minus++;
        else if(paper[startY][startX]==0)
            zero++;
        else
            plus++;
    }
}
