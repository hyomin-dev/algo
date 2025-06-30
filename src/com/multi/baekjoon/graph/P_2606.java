package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_2606 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int connectedNum = Integer.parseInt(br.readLine());

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());
        for(int i=0;i<connectedNum;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);

        }

        visited = new boolean[n+1];

        //dfs(1);
        bfs(1);

        int count= 0;
        for(int i=1;i<=n;i++){
            if(visited[i])
                count++;
        }
        bw.write(String.valueOf(count-1)); // 1번 컴퓨터 제외
        bw.flush();
        bw.close();
        br.close();


    }
    static void dfs(int node){
        visited[node] = true;

        for(int adjacentNode: graph.get(node)){
            if(!visited[adjacentNode])
                dfs(adjacentNode);
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int x = q.poll();

            for(int adjacentNode: graph.get(x)){
                if(!visited[adjacentNode]){
                    q.offer(adjacentNode);
                    visited[adjacentNode] = true;
                }
            }
        }

    }
}
