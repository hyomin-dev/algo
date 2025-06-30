package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_10451 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 갯수

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine()); // 순열의 크기
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph = new ArrayList<>();
            graph.add(new ArrayList<>()); // 노드 번호 0을 삽입, 인덱스 맞추기 위한 용도
            for(int j=1;j<=n;j++){
                graph.add(new ArrayList<>());
            }
            visited = new boolean[n+1];
            count = 0;

            for(int j=1;j<=n;j++){
                graph.get(j).add(Integer.parseInt(st.nextToken()));
            }

            for(int j=1;j<=n;j++){
                if(!visited[j]){
                    //dfs(j);
                    bfs(j);
                    count++;
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();

        }
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int node){

        visited[node] = true;

        for(int i=0;i<graph.get(node).size();i++){
            int adjacentNode = graph.get(node).get(i);
            if(!visited[adjacentNode])
                dfs(adjacentNode);
        }
    }

    static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int x = q.poll();

            for(int i=0;i<graph.get(x).size();i++){
                int adjacentNode = graph.get(x).get(i);
                if(!visited[adjacentNode]){
                    visited[adjacentNode] = true;
                    q.offer(adjacentNode);
                }
            }
        }

    }
}
