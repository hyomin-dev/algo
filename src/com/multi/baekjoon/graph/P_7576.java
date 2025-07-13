package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_7576 {
    static int m,n;
    static boolean[][] visited;
    static int[] dx = new int[]{0,1,0,-1}; // 상 우 하 좌
    static int[] dy = new int[]{-1,0,1,0}; // 상 우 하 좌

    static int count = 0; // 익은 토마토+ 익지 않은 토마토가 익은 경우 + 토마토가 없는 칸
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 가로 칸의 수
        n = Integer.parseInt(st.nextToken()); // 세로 칸의 수
        ArrayList<int[]> startList = new ArrayList<>();

        visited = new boolean[n][m];

        for(int y=0;y<n;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0;x<m;x++){
                int box = Integer.parseInt(st.nextToken());
                if(box==1){ // 익은 토마토가 있는 칸
                    visited[y][x] = true;
                    count++;
                    startList.add(new int[]{x,y,0});
                }else if(box==-1){ // 토마토가 없는 칸 --> 방문 처리
                    visited[y][x] = true;
                    count++;
                }
            }
        }

        int result = bfs(startList);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(ArrayList<int[]> startList){
        Queue<int[]> q = new LinkedList<>();
        int day = 0;
        for(int[] ele: startList)
            q.offer(ele);

        while(!q.isEmpty()){

            int[] box = q.poll();
            if(day<box[2])
                day = box[2];

            for(int d=0;d<4;d++){
                int adjcencyX = box[0] + dx[d];
                int adjcencyY = box[1] + dy[d];

                if(adjcencyX<0 || adjcencyX >=m || adjcencyY <0 || adjcencyY>=n)
                    continue;

                if(!visited[adjcencyY][adjcencyX]){
                    visited[adjcencyY][adjcencyX] = true;
                    count++;
                    q.offer(new int[]{adjcencyX, adjcencyY, box[2]+1});
                }
            }
        }

        if(n*m==count)
            return day;
        else
            return -1;
    }
}

/*

익은 토마토와 인접한 곳에 있는 익지 않은 토마토는 하루가 지나면 익는다.

인접한 곳의 의미: 왼쪽, 오른쪽, 앞, 뒤

입력:
M: 가로 칸의 수, N: 세로 칸의 수, 2 <= M, N <= 1,000

1: 익은 토마토, 0: 익지 않은 토마토, -1: 토마토가 없는 칸

입력은 토마토가 하나 이상 있는 경우만 주어짐

*
* */
