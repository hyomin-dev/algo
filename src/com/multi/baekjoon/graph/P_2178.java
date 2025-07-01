package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_2178 {

    static ArrayList<ArrayList<ArrayList<Integer[]>>> graph = new ArrayList<>(); //row , 배열에는 x,y를 저장
    static int n;
    static int m;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 2<=n, 세로
        m = Integer.parseInt(st.nextToken()); // m<=100, 가로

        int[][] maze = new int[n][m]; // (0,0) ==> (1,1)임
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                maze[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>()); //column
            for(int j=0;j<m;j++){
                graph.get(i).add(new ArrayList<>()); //node
            }
        }

        for(int i=0;i<n;i++){ // row
            for(int j=0;j<m;j++){ //column
                if(maze[i][j]==1)
                    makeAdjacencyList(maze,j,i);
            }
        }

        int result = bfs(0,0);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(int nodeX, int nodeY){
        int count = 1;
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{nodeX, nodeY,count});
        visited[nodeY][nodeX] = true;

        while(!q.isEmpty()){
            Integer[] searchNode = q.poll(); //주변 노드 탐색

            for(Integer[] adjacencyNode : graph.get(searchNode[1]).get(searchNode[0])){
                if(adjacencyNode[0]==m-1&&adjacencyNode[1]==n-1) //인접 노드가 도착 지점인 경우,
                    return searchNode[2]+1;

                if(!visited[adjacencyNode[1]][adjacencyNode[0]]){
                    visited[adjacencyNode[1]][adjacencyNode[0]] = true; // 방문 처리
                    q.offer(new Integer[]{adjacencyNode[0],adjacencyNode[1],searchNode[2]+1});
                }
            }
        }
        return -1;

    }

    static void makeAdjacencyList(int[][] maze, int x, int y){

        // 자신의 것만 graph에 담으면 중복 발생 안함

        // top
        if(y-1>=0&&maze[y-1][x]==1){
            graph.get(y).get(x).add(new Integer[]{x,y-1});
            //graph.get(y-1).get(x).add(new Integer[]{x,y});
        }

        // right
        if(x+1<m&&maze[y][x+1]==1){ //m-1까지는 ok
            graph.get(y).get(x).add(new Integer[]{x+1,y});
            //graph.get(y).get(x+1).add(new Integer[]{x,y});
        }

        // bottom
        if(y+1<n&&maze[y+1][x]==1){ // n-1까지는 ok
            graph.get(y).get(x).add(new Integer[]{x,y+1});
            //graph.get(y+1).get(x).add(new Integer[]{x,y});
        }

        // left
        if(x-1>=0&&maze[y][x-1]==1){
            graph.get(y).get(x).add(new Integer[]{x-1,y});
            //graph.get(y).get(x-1).add(new Integer[]{x,y});
        }
    }
}
