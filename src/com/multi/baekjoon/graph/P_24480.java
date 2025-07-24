package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_24480 {
    static int n,m;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visitedList;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        visitedList = new int[n+1];

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=1;i<=n;i++)
            Collections.sort(graph.get(i),Collections.reverseOrder());

        visited[r] = true;
        dfs(r);

        for(int i=1;i<=n;i++)
            bw.write(visitedList[i]+"\n");

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int node){
        visitedList[node] = count++;

        for(int i=0;i<graph.get(node).size();i++){
            int adjcencyNode = graph.get(node).get(i);
            if(!visited[adjcencyNode]){
                visited[adjcencyNode] = true;
                dfs(adjcencyNode);
            }
        }
    }
}
