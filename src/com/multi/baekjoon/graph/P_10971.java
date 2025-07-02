package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_10971 {

    static ArrayList<ArrayList<Integer[]>> graph = new ArrayList<>(); // column용
    static int n;
    static boolean[] visited;
    static int start;
    static int distance;
    static int minDistance = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine()); // 도시의 수, 2 <= n <=10

        int[][] adjcencyMatrix = new int[n][n];

        for(int y=0;y<n;y++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x=0;x<n;x++){
                adjcencyMatrix[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int y=0;y<n;y++){
            graph.add(new ArrayList<>());
            for(int x=0;x<n;x++){
                if(adjcencyMatrix[y][x]!=0)
                    graph.get(y).add(new Integer[]{x,adjcencyMatrix[y][x]});
            }
        }

        for(int i=0;i<n;i++){
            start = i;
            distance = 0;
            visited = new boolean[n];
            dfs(i);
        }

        bw.write(String.valueOf(minDistance));
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int node){
        visited[node] = true;

        if(isTravelingAll()){ // 모든 노드를 다 방문한 경우
            for(Integer[] adjcencyNode: graph.get(node)){
                if(adjcencyNode[0]==start) {
                    int startDistance = adjcencyNode[1];
                    distance +=startDistance; //시작 노드 이동 거리 추가, 방문
                    if(distance < minDistance || minDistance==0)
                        minDistance = distance;
                    distance -=startDistance; // 시작 노드 이동 거리 차감, 방문 취소
                    break;
                }
            }
        }

        for(Integer[] adjcencyNode: graph.get(node)){
            if(!visited[adjcencyNode[0]]){
                distance += adjcencyNode[1]; // 인접 노드 방문 시 이동 거리 추가
                dfs(adjcencyNode[0]); // 인접 노드 방문
                distance -=adjcencyNode[1]; // 인접 노드 방문을 취소
                visited[adjcencyNode[0]] = false;
            }
        }
    }

    static boolean isTravelingAll(){
        int sum=0;
        for(boolean b: visited){
            if(b)
                sum+=1;
        }
        return sum == n;
    }
}
/*
*
* */
