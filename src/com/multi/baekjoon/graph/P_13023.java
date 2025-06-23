package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_13023 {
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // node 수
        int m = Integer.parseInt(st.nextToken()); // edge 수



        for(int i=0;i<n;i++)
            graph.add(new ArrayList<Integer>());

        int i=0;
        while(i<m){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
            i++;
        }

        boolean hasFriend = false;
        for(int k=0;k<n&&!hasFriend;k++){ //모든 노드 반복문처리
            count = 0;
            visited = new boolean[n];
            dfs(k);
            if(count >=5){
                hasFriend = true;
                break;
            }
        }

        if(hasFriend)
            bw.write("1");
        else
            bw.write("0");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int node){
        visited[node] = true;
        count ++;
        for(int i=0;i<graph.get(node).size();i++){
            int adjacentNode = graph.get(node).get(i);
            if(!visited[adjacentNode])
                dfs(adjacentNode);
        }
    }
}
