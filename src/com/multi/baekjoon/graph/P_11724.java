package com.multi.baekjoon.graph;


import java.io.*;
import java.util.*;

public class P_11724 {

    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        graph = new ArrayList<>();

        for(int i=0;i<N;i++)
            graph.add(new ArrayList<Integer>());

        int i=0;
        while(i<M){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
            i++;
        }

       int count = 0;
        for(i=1;i<N;i++){
            if(!visited[i]){
                dfs(i);
                count ++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int node){

        visited[node] = true;
        for(int i=0;i<graph.get(node).size();i++){
            int adjacentNode = graph.get(node).get(i);
            if(!visited[adjacentNode])
                dfs(adjacentNode);
        }

    }
}
