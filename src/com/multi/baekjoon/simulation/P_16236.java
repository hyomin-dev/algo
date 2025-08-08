package com.multi.baekjoon.simulation;

import java.io.*;
import java.util.*;

public class P_16236 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0; // 물고기의 수
    static int size = 2; // 아기 상어 크기
    static int fishCount = 0; // 아기 상어가 자신보다 작은 물고기를 먹은 횟수
    static int maxDist = 0; // 이동한 최대 거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        int[] start = new int[2]; // 아기 상어 초기 위치(x, y)

        for(int y=0;y<n;y++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x=0;x<n;x++){
                map[y][x] = Integer.parseInt(st.nextToken());
                if(map[y][x]==9){
                    start[0] = x;
                    start[1] = y;
                    map[y][x] = 0; // 아기 상어가 원래 있던 곳도 이동할 수 있게 빈 칸으로 초기화
                }else if(map[y][x]>0) {
                    count++;
                }
            }
        }

        bfs(start);

        bw.write(maxDist+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int[] start){
        PriorityQueue<Node16236> pq = new PriorityQueue<>();
        pq.offer(new Node16236(start[0], start[1], 0));
        visited[start[1]][start[0]] = true;

        int[] dx = new int[]{0, -1, 1, 0}; // 상 좌 우 하
        int[] dy = new int[]{-1, 0, 0, 1}; // 상 좌 우 하

        while(!pq.isEmpty()){
            Node16236 node = pq.poll();

            if(map[node.y][node.x]!=0&&map[node.y][node.x]<size) { // 빈 칸아님 and 해당 칸의 물고기가 아기 상어보다 작은 경우

                if(node.dist>maxDist)
                    maxDist = node.dist;

                map[node.y][node.x] = 0; // 물고기를 먹음
                fishCount++;
                if(fishCount==size){ // 아기 상어의 크기와 물고기를 먹은 횟수가 같은 경우 --> 아기 상어 크기 1 증가
                    size++;
                    fishCount = 0;
                }
                pq = new PriorityQueue<>(); // 물고기를 먹을 때 마다 초기화를 해준다.
                visited = new boolean[n][n]; // 방문 여부 초기화
                visited[node.y][node.x] = true;
            }

            // 주변 노드 탐색

            for(int i=0;i<4;i++){
                int adjcencyX = node.x + dx[i];
                int adjcencyY = node.y + dy[i];

                if(adjcencyX <0 || adjcencyX >=n || adjcencyY <0 || adjcencyY >=n)
                    continue;
                if(map[adjcencyY][adjcencyX]>size) // 인접 노드에 있는 물고기의 크기가 아기 상어 크기보다 클 경우
                    continue;
                else if(!visited[adjcencyY][adjcencyX]){ // 빈 칸, 물고기의 크기가 아기 상어의 크기 보다 작거나 같은 경우
                    pq.offer(new Node16236(adjcencyX, adjcencyY, node.dist + 1));
                    visited[adjcencyY][adjcencyX] = true;
                }

            }
        }
    }
}

class Node16236 implements Comparable<Node16236>{

    int x;
    int y;
    int dist;

    public Node16236(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node16236 o){
        if(this.dist !=o.dist){ // 거리를 기준으로 오름 차순 정렬
            return this.dist - o.dist;
        }else if(this.y!=o.y){ // y 값을 기준으로 오름 차순 정렬
            return this.y - o.y;
        }else if(this.x!=o.x){ // x 값을 기준으로 오름 차순 정렬
            return this.x -o.x;
        }else{ // 거리, y값, x값이 모두 같은 경우
            return 0;
        }
    }
}

/*
이동: 상 하 좌 우

이동 가능: 빈칸, 자신보다 작거나 같은 물고기가 있는 칸

먹는 순서: 거리가 가까운 물고기 -> 가장 위에 있는 물고기 -> 가장 왼쪽에 있는 물고기

물고기 먹으면 -> 빈 칸이 됨 -> 해당 칸을 다시 지나갈 수 있음

상어 크기: 자신의 크기가 n이라면 n개의 물고기를 먹으면 크키가 1 증가함

한 개 행렬 크기: 20 X 20 X 4 =1600Byte

bfs로 풀기, 우선순위 큐, 각 상태마다 물고기 상태와 현재 위치 저장하기, 시간 저장하기

* */