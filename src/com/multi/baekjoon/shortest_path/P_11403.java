package com.multi.baekjoon.shortest_path;


import java.io.*;
import java.util.StringTokenizer;

public class P_11403 {

    public static void main(String[] args) throws IOException {

        final int INF = (int)1e9;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 정점의 개수, 1 <= n <= 100

        int[][] graph = new int[n+1][n+1];

        for(int y=1;y<=n;y++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x=1;x<=n;x++){
                int value = Integer.parseInt(st.nextToken());
                if(value==0)
                    graph[y][x] = INF;
                else
                    graph[y][x] = value;
            }
        }

        for(int k=1;k<=n;k++){
            for(int y=1;y<=n;y++){
                for(int x=1;x<=n;x++){
                    graph[y][x] = Math.min(graph[y][x],graph[y][k]+graph[k][x]);
                }
            }
        }

        for(int y=1;y<=n;y++){
            for(int x=1;x<=n;x++){
                if(graph[y][x]==INF)
                    bw.write("0 ");
                else
                    bw.write("1 ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
