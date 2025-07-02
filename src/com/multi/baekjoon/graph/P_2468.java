package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_2468 {

    static ArrayList<ArrayList<ArrayList<Integer[]>>> graph;
    static boolean[][] visited;
    static int[][] district;
    static int n; // 행과 열의 갯수, 2 <= n <=100
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        district = new int[n][n];

        int maxH = 1; // 1 <= h <=100

        int maxSafeRegion = 1; // 어떠한 지점도 잠기지 않은 경우

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens()){
                district[i][j] = Integer.parseInt(st.nextToken());
                if(maxH<district[i][j])
                    maxH = district[i][j];
                j++;
            }
        }

        for(int rain = 1;rain<maxH;rain++){
            graph = new ArrayList<>(); //row용
            for(int i=0;i<n;i++){
                graph.add(new ArrayList<>()); // column용
                for(int j=0;j<n;j++){
                    graph.get(i).add(new ArrayList<>()); // node 좌표 담는 용
                }
            }

            for(int i=0;i<n;i++){ // row
                for(int j=0;j<n;j++){   // column
                    if(district[i][j]>rain) //물에 잠기지 않은 영역인 경우
                        setGraph(j,i, rain);
                }
            }

            visited = new boolean[n][n];
            int count = 0;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(!visited[i][j]&&district[i][j]>rain){
                        //dfs(new Integer[]{j, i});
                        bfs(new Integer[]{j,i});
                        count++;
                    }
                }
            }

            if(count>maxSafeRegion)
                maxSafeRegion = count;

        }

        bw.write(String.valueOf(maxSafeRegion));
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(Integer[] start){
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[1]][start[0]] = true;

        while(!q.isEmpty()){
            Integer[] searchNode = q.poll();
            int searchNodeX = searchNode[0];
            int searchNodeY = searchNode[1];

            for(Integer[] adjcencyNode: graph.get(searchNodeY).get(searchNodeX)){
                int adjcencyNodeX = adjcencyNode[0];
                int adjcencyNodeY = adjcencyNode[1];
                if(!visited[adjcencyNodeY][adjcencyNodeX]){
                    q.offer(adjcencyNode);
                    visited[adjcencyNodeY][adjcencyNodeX] = true;
                }
            }
        }
    }

    static void dfs(Integer[] node){

        int x = node[0];
        int y = node[1];

        visited[y][x] = true;

        for(Integer[] adjcencyNode: graph.get(y).get(x)){
            if(!visited[adjcencyNode[1]][adjcencyNode[0]])
                dfs(adjcencyNode);
        }

    }

    static void setGraph(int x, int y, int rain){

        if(district[y][x]<=rain)
            return; // 물에 잠긴 영역

        // top
        if(y-1>=0&&district[y-1][x]>rain)
            graph.get(y).get(x).add(new Integer[]{x, y-1});

        // right
        if(x+1<n&&district[y][x+1]>rain)
            graph.get(y).get(x).add(new Integer[]{x+1, y});

        // bottom
        if(y+1<n&&district[y+1][x]>rain)
            graph.get(y).get(x).add(new Integer[]{x, y+1});

        // left
        if(x-1>=0&&district[y][x-1]>rain)
            graph.get(y).get(x).add(new Integer[]{x-1, y});
    }
}
