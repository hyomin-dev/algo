package com.multi.baekjoon.graph;


import java.io.*;
import java.util.*;

public class P_2583 {
    static ArrayList<ArrayList<ArrayList<Integer[]>>> graph = new ArrayList<>(); // row용
    static boolean[][] visited;
    static int m; // 세로, 1 <= m <= 100
    static int n; // 가로, 1 <= n <= 100
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 직사각형 갯수, 1 <= k <= 100

        int[][] map = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int newY1 = m - Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int newY2 = m - Integer.parseInt(st.nextToken());

            for(int y=0;y<m;y++){
                for(int x=0;x<n;x++){
                    if(x1<=x && x<x2 && newY2 <= y && y<newY1)
                        map[y][x] = 1; // 눈금 부분: 1
                    else
                        map[y][x] += 0 ; // 눈금 안닌 부분:0
                }
            }

        }

        for(int y=0;y<m;y++){
            graph.add(new ArrayList<>());
            for(int x=0;x<n;x++){
                graph.get(y).add(new ArrayList<>());
            }
        }

        for(int y=0;y<m;y++){
            for(int x=0;x<n;x++){
                if(map[y][x]==0)
                    setGraph(map, x,y);
            }
        }

        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for(int y=0;y<m;y++){
            for(int x=0;x<n;x++){
                if(!visited[y][x]&&map[y][x]==0){
                    //dfs(new Integer[]{x,y});
                    bfs(new Integer[]{x, y});
                    int searchRegion = calSearchRegion();
                    result.add(searchRegion-count); // 총영역 - 직전 까지 계산된 영역
                    count = searchRegion;
                }
            }
        }

        Collections.sort(result);

        bw.write(String.valueOf(result.size()));
        bw.newLine();

        for(int i=0;i<result.size();i++){
            bw.write(result.get(i)+" ");
        }

        bw.flush();
        bw.close();
        br.close();

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

    static void bfs(Integer[] start){
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[1]][start[0]] = true;

        while(!q.isEmpty()){
            Integer[] searchNode = q.poll();

            for(Integer[] adjcencyNode: graph.get(searchNode[1]).get(searchNode[0])){
                if(!visited[adjcencyNode[1]][adjcencyNode[0]]) {
                    q.offer(adjcencyNode);
                    visited[adjcencyNode[1]][adjcencyNode[0]] = true;
                }
            }
        }
    }

    static int calSearchRegion(){
        int sum = 0;
        for(int y=0;y<m;y++){
            for(int x=0;x<n;x++){
                if(visited[y][x])
                    sum +=1;
            }
        }
        return sum;
    }

    static void setGraph(int[][] map, int x, int y){

        // top
        if(y-1>=0&&map[y-1][x]==0)
            graph.get(y).get(x).add(new Integer[]{x, y-1});

        // right
        if(x+1<n&&map[y][x+1]==0)
            graph.get(y).get(x).add(new Integer[]{x+1, y});

        // botton
        if(y+1<m&&map[y+1][x]==0)
            graph.get(y).get(x).add(new Integer[]{x,y+1});

        // left
        if(x-1>=0&&map[y][x-1]==0)
            graph.get(y).get(x).add(new Integer[]{x-1,y});
    }
}

/*
* M - oriY = newY
* 왼쪽 아래: (x1, y1), 오른쪽 위: (x2, y2) ==> x1 < x2, y1 < y2
* M-y1 > M - y2 ==> newY1 > newY2
* */
