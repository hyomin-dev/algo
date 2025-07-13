package com.multi.baekjoon.graph;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_7562 {
    static int i;
    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};
    static boolean[][] visited;

    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while(t>0){
            int[] start = new int[3];
            int[] dest = new int[2];
            i = Integer.parseInt(br.readLine());
            visited = new boolean[i][i];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken()); // start x좌표
            start[1] = Integer.parseInt(st.nextToken()); // start y좌표
            start[2] = 0; // 초기 이동 횟수
            count = 0;
            visited[start[1]][start[0]] = true; //초기 좌표 방문 처리

            st = new StringTokenizer(br.readLine());
            dest[0] = Integer.parseInt(st.nextToken()); // destination x좌표
            dest[1] = Integer.parseInt(st.nextToken()); // destination y좌표

            dfs(start,dest);
            bw.write(count+"\n");
            t--;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int[] start, int[] dest){
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int[] x = q.poll();
            if(x[0]==dest[0]&&x[1]==dest[1]){
                count = x[2];
                return;
            }

            //주변 좌표 q에 삽입
            for(int n=0;n<8;n++){
                int moveX = x[0] + dx[n];
                int moveY = x[1] + dy[n];
                if(moveX<0 || moveX>=i || moveY <0 || moveY >=i)
                    continue;
                if(!visited[moveY][moveX]){
                    visited[moveY][moveX] = true;
                    q.offer(new int[]{moveX,moveY,x[2]+1});
                }
            }

        }
    }
}
