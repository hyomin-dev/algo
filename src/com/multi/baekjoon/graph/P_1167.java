package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_1167 {
    static int v;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int maxDiameter = Integer.MIN_VALUE;
    static int maxNode = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        v = Integer.parseInt(br.readLine());

        for(int i=0;i<=v;i++)
            graph.add(new ArrayList<>());

        for(int i=1;i<=v;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());

            while(true){
                int adjcency = Integer.parseInt(st.nextToken());
                if(adjcency==-1)
                    break;

                int length = Integer.parseInt(st.nextToken());

                graph.get(node1).add(new int[]{adjcency, length});
                graph.get(adjcency).add(new int[]{node1, length});

            }
        }

        //임의의 정점에서 가장 먼 노드 찾기

        visited = new boolean[v+1];
        visited[1] = true;
        dfs(1,0);

        visited = new boolean[v+1];
        visited[maxNode] = true;
        dfs(maxNode,0);

        bw.write(maxDiameter+"");
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int node, int sum){
        if(sum>maxDiameter){
            maxDiameter = sum;
            maxNode = node;
        }

        for(int i=0;i<graph.get(node).size();i++){
            int[] adjcencyNode = graph.get(node).get(i);
            if(!visited[adjcencyNode[0]]){
                visited[adjcencyNode[0]] = true;
                dfs(adjcencyNode[0],sum+adjcencyNode[1]);
            }
        }


    }

}
