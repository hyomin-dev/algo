package com.multi.baekjoon.graph;


import java.io.*;
import java.util.*;

public class P_2667 {

    static ArrayList<ArrayList<ArrayList<Integer[]>>> graph = new ArrayList<>(); // row용
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        n = Integer.parseInt(br.readLine()); // 5 <= n <=25

        int[][] map = new int[n][n];

        visited = new boolean[n][n]; // node 방문 여부

        int sum=0; // 총 집의 수를 저장함
        ArrayList<Integer> list = new ArrayList<>(); // 각 단지내 집의 수를 저장

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<str.length();j++)
                map[i][j] = str.charAt(j) - '0';
        }

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>()); // column 용
            for(int j=0;j<n;j++){
                graph.get(i).add(new ArrayList<>()); // node용
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                setGraph(map, j,i);
            }
        }

        for(int i=0;i<n;i++){ // row
            for(int j=0;j<n;j++){ // col
                if(!visited[i][j]&&map[i][j]==1){
                    //dfs(j, i);
                    bfs(j,i);

                    if(list.isEmpty()){
                        sum = sumVisited();
                        list.add(sum);
                    }else{
                        int count = sumVisited() - sum;
                        sum += count;
                        list.add(count);
                    }
                }
            }
        }
        bw.write(String.valueOf(list.size()));
        bw.newLine();
        if(!list.isEmpty()){
            Collections.sort(list);
            for(int num: list) {
                bw.write(String.valueOf(num));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static int sumVisited(){
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j])
                    sum += 1;
            }
        }
        return sum;
    }

    static void dfs(int x, int y){
        visited[y][x] = true;

        for(Integer[] adjcencyNode : graph.get(y).get(x)){
            if(!visited[adjcencyNode[1]][adjcencyNode[0]]){ // 인접 노드를 방문하지 않은 경우
                dfs(adjcencyNode[0], adjcencyNode[1]);
            }
        }
    }

    static void bfs(int x, int y){
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{x, y});
        visited[y][x] =true;
        while(!q.isEmpty()){
            Integer[] searchNode = q.poll();
            for(Integer[] adjcencyNode: graph.get(searchNode[1]).get(searchNode[0])){
                if(!visited[adjcencyNode[1]][adjcencyNode[0]]){
                    q.offer(new Integer[]{adjcencyNode[0],adjcencyNode[1]});
                    visited[adjcencyNode[1]][adjcencyNode[0]] = true;
                }
            }

        }
    }

    static void setGraph(int[][] map, int x, int y){

        // top
        if(y-1>=0&&map[y-1][x]==1)
            graph.get(y).get(x).add(new Integer[]{x,y-1});

        // right
        if(x+1<n&&map[y][x+1]==1)
            graph.get(y).get(x).add(new Integer[]{x+1, y});

        // bottom
        if(y+1<n&&map[y+1][x]==1)
            graph.get(y).get(x).add(new Integer[]{x, y+1});

        //left
        if(x-1>=0&&map[y][x-1]==1)
            graph.get(y).get(x).add(new Integer[]{x-1,y});
    }
}
