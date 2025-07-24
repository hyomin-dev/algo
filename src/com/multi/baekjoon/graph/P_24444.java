package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_24444 {
    static int n,m,r;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] visitedList;
    static int visitedOrder = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        visitedList = new int[n+1];
        visited = new boolean[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=1;i<=n;i++)
            Collections.sort(graph.get(i));

        bfs(r);

        for(int i=1;i<=n;i++)
            bw.write(visitedList[i]+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        visitedList[start] = visitedOrder++;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int i=0;i<graph.get(node).size();i++){
                int adjcencyNode = graph.get(node).get(i);
                if(!visited[adjcencyNode]){
                    visited[adjcencyNode] = true;
                    visitedList[adjcencyNode] = visitedOrder++;
                    queue.offer(adjcencyNode);
                }
            }

        }
    }
}
