package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 색 종이의 수


        boolean[][] square = new boolean[100+1][100+1];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            for(int y=n2;y<n2+10;y++){
                for(int x=n1;x<n1+10;x++){
                    square[y][x] = true;
                }
            }
        }

        int count = 0;
        for(int y=1;y<=100;y++){
            for(int x=1;x<=100;x++){
                if(square[y][x])
                    count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }
}
