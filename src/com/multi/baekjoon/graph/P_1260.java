package com.multi.baekjoon.graph;


import java.io.*;
import java.util.*;

public class P_1260 {
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for(int i=0;i<n+1;i++) // 1번 노드 부터 시작하기 위함
            graph.add(new ArrayList<Integer>());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());

            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);

        }
        for(int i=0;i<n+1;i++)
            Collections.sort(graph.get(i));


        //dfs
        visited = new boolean[n+1]; // 1번 노드 부터 시작하기 위함
        dfs(v);
        bw.newLine();
        //bfs
        visited = new boolean[n+1]; // 1번 노드 부터 시작하기 위함
        bfs(v);

        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int node) throws IOException{
        visited[node] = true;
        bw.write(node+" ");
        for(int i =0;i<graph.get(node).size();i++){
            int adjacentNode = graph.get(node).get(i);
            if(!visited[adjacentNode])
                dfs(adjacentNode);
        }

    }

    public static void bfs(int node) throws IOException{
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        bw.write(node+" ");
        while(!q.isEmpty()){

            int x = q.poll();

            for(int i=0;i<graph.get(x).size();i++){
                int adjacentNode = graph.get(x).get(i);
                if(!visited[adjacentNode]){
                    q.offer(adjacentNode);
                    visited[adjacentNode] = true;
                    bw.write(adjacentNode+" ");
                }

            }

        }



    }
}
