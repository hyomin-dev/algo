package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_13023 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int depth;
    static int result=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // node 수
        int m = Integer.parseInt(st.nextToken()); // edge 수

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());

        int i=0;
        while(i<m){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
            i++;
        }

        for(i=0;i<n;i++){
            depth = 1;
            visited = new boolean[n];
            visited[i] = true;
            dfs(i);
            if(result ==1)
                break;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int node){

        if(depth==5){
            result = 1;
        }

        if(result ==1)
            return;

        for(int i=0;i<graph.get(node).size();i++){
            int adjacentNode = graph.get(node).get(i);
            if(!visited[adjacentNode]) {
                depth++;
                visited[adjacentNode] = true;
                dfs(adjacentNode);
                visited[adjacentNode] = false;
                depth--;
            }
        }
    }
}

/*
* 반례:
* 5 5
0 2
2 4
0 1
0 3
1 2
* */
