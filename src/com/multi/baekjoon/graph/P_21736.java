package com.multi.baekjoon.graph;

import java.util.*;
import java.io.*;

public class P_21736 {

    static int n,m;
    static boolean[][] visited;
    static char[][] map;
    static int count = 0;
    static int[] dx = new int[]{0,0,-1,1}; // 상 하 좌 우
    static int[] dy = new int[]{-1,1,0,0}; // 상 하 좌 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        map = new char[n][m];
        visited = new boolean[n][m];

        int[] start = new int[2];
        for(int y=0;y<n;y++){
            String row = br.readLine();
            for(int x=0;x<m;x++){
                map[y][x] = row.charAt(x);
                if(map[y][x]=='I') {
                    start[0] = x;
                    start[1] = y;
                } else if(map[y][x]=='X')
                    visited[y][x] = true;
            }
        }

        bfs(start);

        if(count ==0)
            bw.write("TT");
        else
            bw.write(count+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int[] start){
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(start);
        visited[start[1]][start[0]] = true;
        while(!q.isEmpty()){

            int[] node = q.poll();
            for(int i=0;i<4;i++){
                int moveX = node[0] + dx[i];
                int moveY = node[1] + dy[i];

                if(moveX<0 || moveX>=m || moveY <0 || moveY >=n)
                    continue;
                if(!visited[moveY][moveX]){
                    q.offer(new int[]{moveX, moveY});
                    visited[moveY][moveX] = true;
                    if(map[moveY][moveX]=='P')
                        count++;
                }
            }
        }
    }
}
