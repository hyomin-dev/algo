package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_2644_BFS {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int p1;
    static int p2;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 전체 사람 수, 1<= n <= 100

        StringTokenizer st = new StringTokenizer(br.readLine());

        p1 = Integer.parseInt(st.nextToken()) -1; // 사람1
        p2 = Integer.parseInt(st.nextToken()) -1; // 사람2

        int m = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        visited = new boolean[n];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken())-1;
            int child = Integer.parseInt(st.nextToken())-1;

            graph.get(parent).add(child);
            graph.get(child).add(parent);

        }

        bfs(p1);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int start){

        Queue<Integer[]> q = new LinkedList<>();

        q.offer(new Integer[]{start, 0});

        while(!q.isEmpty()){
            Integer[] searchNode = q.poll();

            if(searchNode[0]==p2)
                result =  searchNode[1];

            for(int adjcencyNode: graph.get(searchNode[0])){
                if(!visited[adjcencyNode]){
                    q.offer(new Integer[]{adjcencyNode, searchNode[1]+1});
                    visited[adjcencyNode] = true;
                }
            }
        }
    }
}
