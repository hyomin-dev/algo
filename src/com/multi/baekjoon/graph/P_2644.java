package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_2644 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int p1;
    static int p2;
    static int count;
    static int result = -1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 전체 사람 수, 1<= n <= 100

        StringTokenizer st = new StringTokenizer(br.readLine());

        p1 = Integer.parseInt(st.nextToken()) -1; // 사람1
        p2 = Integer.parseInt(st.nextToken()) -1; // 사람2

        int m = Integer.parseInt(br.readLine());

        // node는 0부터 시작

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
        dfs(p1);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int node){
        visited[node] = true;
        if(node==p2)
            result = count;
        for(int adjacencyNode : graph.get(node)){
            if(!visited[adjacencyNode]){
                count++; // 깊이 탐색을 할 때 증가
                dfs(adjacencyNode);
                count--; // 깊이 탐색을 끝냈으면 감소
            }
        }
    }
}
