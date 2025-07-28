package com.multi.baekjoon.shortest_path;

import java.io.*;
import java.util.*;

public class P_1956 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        if(e==0){
            bw.write("-1");
        }else{
            int[][] graph = new int[v+1][v+1];

            final int INF = (int)1e9;
            for(int y=1;y<=v;y++)
                Arrays.fill(graph[y],INF);

            for(int i=1;i<=v;i++)
                graph[i][i] = 0;

            while(e>0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph[a][b] = c;

                e--;
            }

            for(int k=1;k<=v;k++){
                for(int y=1;y<=v;y++){
                    for(int x=1;x<=v;x++){
                        graph[y][x] = Math.min(graph[y][x],graph[y][k]+graph[k][x]);
                    }
                }
            }

            int minValue = Integer.MAX_VALUE;

            for(int y=1;y<=v;y++){
                for(int x=y+1;x<=v;x++){
                    int cycle = graph[y][x] + graph[x][y];
                    if(cycle<minValue)
                        minValue = cycle;
                }
            }

            if(minValue>=INF)
                bw.write("-1");
            else
                bw.write(minValue+"");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

/*
1. 플로이드 워셜로 각지점마다 다른 경로에 도착하는 최단 거리를 구함

2. (a,b)와 (b,a)를 사이클보고 이러한 사이클이 최소가 되는 곳을 구함

* */
