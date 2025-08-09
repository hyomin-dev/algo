package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_16724 {
    static int n,m;
    static char[][] map;
    static boolean[][] visited;
    static ArrayList<ArrayList<ArrayList<int[]>>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 행
        m = Integer.parseInt(st.nextToken()); // 열

        map = new char[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
            for(int j=0;j<=m;j++)
                graph.get(i).add(new ArrayList<>());
        }

        for(int y=1;y<=n;y++){
            String s = br.readLine();
            for(int x=1;x<=m;x++){
                map[y][x] = s.charAt(x-1);
            }
        }

        // 그래프 생성
        for(int y=1;y<=n;y++){
            for(int x=1;x<=m;x++){
                setGraph(x,y,map[y][x]);
            }
        }

        int count = 0;
        for(int y=1;y<=n;y++){
            for(int x=1;x<=m;x++){
                if(!visited[y][x]){
                    visited[y][x] = true;
                    dfs(new int[]{x,y});
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }

    static void setGraph(int x, int y, char c){
        int adjX, adjY;
        if(c=='U'){
            adjX = x;
            adjY = y-1;
        }else if(c=='D'){
            adjX = x;
            adjY = y+1;
        }else if(c=='L'){
            adjX = x-1;
            adjY = y;
        }else{ // R
            adjX = x+1;
            adjY = y;
        }

        graph.get(y).get(x).add(new int[]{adjX,adjY});
        graph.get(adjY).get(adjX).add(new int[]{x,y});
    }

    static void dfs(int[] node){
        int x = node[0];
        int y = node[1];

        for(int i=0;i<graph.get(y).get(x).size();i++){
            int[] adjNode = graph.get(y).get(x).get(i);
            int adjX = adjNode[0];
            int adjY = adjNode[1];
            if(!visited[adjY][adjX]){
                visited[adjY][adjX] = true;
                dfs(adjNode);
            }
        }

    }

}

/*
지도를 양방향 그래프로 변환

dfs로 연결된 그래프의 개수를 찾기

* */
