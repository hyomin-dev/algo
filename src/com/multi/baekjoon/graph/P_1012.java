package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_1012 {
    static int[] dx = new int[]{0,0,-1,1}; // 상 하 좌 우
    static int[] dy = new int[]{-1,1,0,0}; // 상 하 좌 우
    static int[][] map;
    static boolean[][] visited;
    static int m,n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){

            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로 길이, 1 <= m <= 50
            n = Integer.parseInt(st.nextToken()); // 세로 길이, 1 <= n <= 50
            int k = Integer.parseInt(st.nextToken()); // 배추의 개수, 1 <= K <= 2500

            map = new int [n][m];
            visited = new boolean[n][m];

            while(k>0){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
                k--;
            }

            int count = 0;

            for(int y=0;y<n;y++){
                for(int x=0;x<m;x++){
                    if(!visited[y][x]&&map[y][x]==1){
                        count++;
                        dfs(new int[]{x, y});
                    }
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();

            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int[] node){
        int x = node[0];
        int y = node[1];
        visited[y][x] = true;

        for(int i=0;i<4;i++){
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if(moveX<0 || moveX>=m || moveY <0 || moveY >=n)
                continue;
            else if(!visited[moveY][moveX]&&map[moveY][moveX]==1){
                dfs(new int[]{moveX, moveY});
            }

        }
    }
}
