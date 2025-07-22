package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;


public class P_10026 {

    static int n;
    static int count1=0, count2=0;
    static char[][] graph1;
    static char[][] graph2;
    static boolean[][] visited;
    static int[] dx = new int[]{0,0,-1,1}; // 상 하 좌 우
    static int[] dy = new int[]{-1,1,0,0}; // 상 하 좌 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        if(n==1){
            String colors = br.readLine();
            bw.write("1 1");
        }else{
            graph1 = new char[n][n];
            graph2 = new char[n][n];

            for(int y=0;y<n;y++){
                String colors = br.readLine();
                for(int x=0;x<n;x++){
                    char c = colors.charAt(x);
                    graph1[y][x] = c;
                    if(c=='G')
                        graph2[y][x] = 'R';
                    else{
                        graph2[y][x] = c;
                    }
                }
            }

            visited = new boolean[n][n];
            for(int y=0;y<n;y++){
                for(int x=0;x<n;x++){
                    if(!visited[y][x]){
                        visited[y][x] = true;
                        bfs(new int[]{x,y}, graph1, graph1[y][x]);
                        count1++;
                    }
                }
            }

            visited = new boolean[n][n];
            for(int y=0;y<n;y++){
                for(int x=0;x<n;x++){
                    if(!visited[y][x]){
                        visited[y][x] = true;
                        bfs(new int[]{x,y},graph2, graph2[y][x]);
                        count2++;
                    }
                }
            }

            bw.write(count1 +" "+count2);
        }


        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int[] start, char[][] graph, char color){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()){

            int[] node = q.poll();

            for(int i=0;i<4;i++){
                int moveX = node[0] + dx[i];
                int moveY = node[1] + dy[i];

                if(moveX<0 || moveX>=n || moveY <0 || moveY >=n)
                    continue;

                if(!visited[moveY][moveX]&&graph[moveY][moveX]==color){
                    q.offer(new int[]{moveX, moveY});
                    visited[moveY][moveX] = true;
                }

            }
        }

    }
}
