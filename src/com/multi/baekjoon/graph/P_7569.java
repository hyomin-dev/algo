package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_7569 {
    static int m,n,h;
    static int[][][] map;
    static boolean[][][] visited;
    static int day = 0; //토마토가 익는데 걸리는 날짜
    static int count = 0; // 방문 횟수
    static int[] dx = new int[]{0, 0, -1, 1, 0, 0}; // 위 아래 왼쪽 오른쪽 앞 뒤
    static int[] dy = new int[]{0, 0, 0, 0, 1, -1}; // 위 아래 왼쪽 오른쪽 앞 뒤
    static int[] dz = new int[]{1, -1, 0, 0, 0, 0}; // 위 아래 왼쪽 오른쪽 앞 뒤
    static ArrayList<int[]> startList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 가로, 2 <= m <= 100
        n = Integer.parseInt(st.nextToken()); // 세로, 2 <= n <= 100
        h = Integer.parseInt(st.nextToken()); // 높이, 1 <= h <= 100;

        // 가장 밑에 상자 부터 위에 상자까지

        // 1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토가 없는 칸

        map = new int[h][n][m]; // 높이, 세로, 가로
        visited = new boolean[h][n][m];

        for(int z=0;z<h;z++){
            for(int y=0;y<n;y++){
                st = new StringTokenizer(br.readLine());
                for(int x=0;x<m;x++){

                    int num = Integer.parseInt(st.nextToken());

                    map[z][y][x] = num;
                    if(num==-1) {
                        visited[z][y][x] = true;
                        count++;
                    }else if(num==1){
                        startList.add(new int[]{x,y,z});
                        visited[z][y][x] = true;
                        count++;
                    }
                }
            }
        }

        bfs();

        if(count==h*n*m)
            bw.write(day+"");
        else
            bw.write("-1");

        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        for(int[] start:startList){
            queue.offer(new int[]{start[0],start[1],start[2],0});

        }


        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            if(node[3]>day)
                day = node[3];

            for(int i=0;i<6;i++){
                int moveX = node[0] + dx[i];
                int moveY = node[1] + dy[i];
                int moveZ = node[2] + dz[i];

                if(moveX <0 || moveX >=m || moveY <0 || moveY >=n || moveZ < 0 || moveZ >=h)
                    continue;
                if(!visited[moveZ][moveY][moveX]&&map[moveZ][moveY][moveX]==0){ // 방문하지 않은 칸이면서, 토마토가 없는 칸이여야됨
                    queue.offer(new int[]{moveX, moveY, moveZ, node[3]+1});
                    visited[moveZ][moveY][moveX] = true;
                    count++;
                }

            }

        }
    }
}
