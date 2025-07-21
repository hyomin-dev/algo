package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_14940 {

    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{0,0,-1,1}; // 상 하 좌 우
    static int[] dy = new int[]{-1,1,0,0}; // 상 하 좌 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        map = new int[n][m];

        visited = new boolean[n][m];
        int[] start = new int[2];

        for(int y=0;y<n;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0;x<m;x++){
                map[y][x] = Integer.parseInt(st.nextToken());
                if(map[y][x]==2) { // 목적지
                    start[0] = x;
                    start[1] = y;

                    map[y][x] = 0;
                    visited[y][x] = true;

                }
                else if(map[y][x]==0) { // 갈 수 없는 땅
                    map[y][x] = 0;
                    visited[y][x] = true;
                }
            }
        }

        bfs(start);

        for(int y=0;y<n;y++){
            for(int x=0;x<m;x++){
                if(!visited[y][x])
                    bw.write("-1 ");
                else
                    bw.write(map[y][x]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int[] start){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0],start[1],0}); // x, y, 거리

        while(!q.isEmpty()){
            int[] node = q.poll();

            for(int i=0;i<4;i++){
                int moveX = node[0] + dx[i];
                int moveY = node[1] + dy[i];

                if(moveX<0 || moveX>=m || moveY<0 || moveY>=n)
                    continue;

                if(!visited[moveY][moveX]&&map[moveY][moveX]!=0){
                    q.offer(new int[]{moveX, moveY, node[2]+1});
                    map[moveY][moveX] = node[2]+1;
                    visited[moveY][moveX] = true;
                }
            }
        }

    }
}
