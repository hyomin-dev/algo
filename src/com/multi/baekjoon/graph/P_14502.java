package com.multi.baekjoon.graph;

import java.util.*;
import java.io.*;

public class P_14502 {

    static int n, m;
    static int[][] graph;
    static int safeRegionNum = Integer.MIN_VALUE;
    static ArrayList<int[]> blankList = new ArrayList<>();
    static ArrayList<int[]> virusList = new ArrayList<>();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 3 <= n,m <= 8
        n = Integer.parseInt(st.nextToken()); // 세로 길이
        m = Integer.parseInt(st.nextToken()); // 가로 길이

        graph = new int[n][m];

        // 0: 빈칸, 1: 벽, 2: 바이러스
        for(int y=0;y<n;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0;x<m;x++){
                graph[y][x] = Integer.parseInt(st.nextToken());
                if(graph[y][x]==0)
                    blankList.add(new int[]{x,y}); // 빈 칸 저장
                else if(graph[y][x]==2)
                    virusList.add(new int[]{x,y}); // 바이러스 저장
            }
        }

        for(int i=0;i<blankList.size();i++){

            int[] node = blankList.get(i);
            graph[node[1]][node[0]] = 1; // 벽 세우기
            dfs(i,1);
            graph[node[1]][node[0]] = 0; // 벽 허물기

        }

        bw.write(safeRegionNum+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int last,int depth){

        if(depth==3){
            int zeroNum = spreadVirus();
            if(zeroNum>safeRegionNum)
                safeRegionNum = zeroNum;
            return;
        }

        for(int i=last+1;i<blankList.size();i++){
            int[] node = blankList.get(i);
            if(graph[node[1]][node[0]]==0){
                graph[node[1]][node[0]] = 1; // 벽세우기
                dfs(i,depth+1);
                graph[node[1]][node[0]] = 0; // 벽 허물기
            }
        }

    }

    static int spreadVirus(){

        int[][] copy = new int[n][m];
        for(int y=0;y<n;y++)
            copy[y] = graph[y].clone();

        int[] dx = new int[]{0,0,-1,1};// 상 하 좌 우
        int[] dy = new int[]{-1,1,0,0}; // 상 하 좌 우

        Queue<int[]> queue = new ArrayDeque<>();
        for(int[] virus: virusList){ //초기 바이러스 위치
            queue.offer(virus);
        }

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            for(int i=0;i<4;i++){
                int moveX = node[0] + dx[i];
                int moveY = node[1] + dy[i];

                if(moveX<0 || moveX >=m || moveY<0 || moveY>=n)
                    continue;

                if(copy[moveY][moveX]==0){ // 주변이 빈 칸이면 바이러스를 퍼트림
                    copy[moveY][moveX] = 2;
                    queue.offer(new int[]{moveX, moveY});
                }

            }
        }

        int count = 0;
        for(int y=0;y<n;y++){
            for(int x=0;x<m;x++){
                if(copy[y][x]==0)
                    count++;
            }
        }

        return count;
    }


}

/*
벽 3개를 세운다 --> 바이러스를 퍼트린다. --> 0의 개수 카운트

* */