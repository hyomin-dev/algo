package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_2638 {

    static int n, m;
    static int[][] map;
    static int airNum;
    static boolean[][] outsideAir; // 외부 공기가 있는 곳
    static int[] dx = new int[]{0,0,-1,1}; // 상 하 좌 우
    static int[] dy = new int[]{-1,1,0,0}; // 상 하 좌 우

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        map = new int[n][m];
        outsideAir = new boolean[n][m];
        for(int y=0;y<n;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0;x<m;x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int result = step();

        bw.write(result+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static int step(){

        int time = 0;
        while(true){

            outsideAir = new boolean[n][m];
            outsideAir[0][0] = true;
            airNum = 1;
            dfs(new int[]{0,0}); // 0,0는 외부 공기가 있는 곳, dfs를 이용해서 외부 공기파악, 직전 melt()에서 치즈가 모두 녹았는지 파악하는 것
            if(airNum==n*m) //
                break;
            time++; // 치즈가 아직 다 녹지 않은 경우 시간이 1시간 늘어남
            melt();
        }
        return time;

    }

    static void dfs(int[] node){

        for(int i=0;i<4;i++){
            int adjX = node[0] + dx[i];
            int adjY = node[1] + dy[i];
            if(adjX <0 || adjX >=m || adjY <0 || adjY >=n) // 격자점을 벗어나는 경우
                continue;

            if(!outsideAir[adjY][adjX]&&map[adjY][adjX]==0){
                outsideAir[adjY][adjX] = true; // 외부 공기인 경우 true처리
                airNum++; // 외부 공기의 수
                dfs(new int[]{adjX,adjY});
            }
        }
    }

    static void melt(){

        for(int y=0;y<n;y++){
            for(int x=0;x<m;x++){
                if(map[y][x]==1){ // 치즈인 경우
                    int count =0; // 외부 공기 수
                    for(int i=0;i<4;i++){
                        int adjX = x+dx[i];
                        int adjY = y+dy[i];

                        if(adjX <0 || adjX >=m || adjY <0 || adjY >=n)// 격자점을 벗어나는 경우
                            continue;
                        if(outsideAir[adjY][adjX]&&map[adjY][adjX]==0){ // 치즈 주변이 외부 공기인 경우
                            count++;
                        }
                        if(count==2) { //치즈가 외부 공기와 2면이상 맞닿은 경우 녹음
                            map[y][x] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
}

/*
* 치즈 내부 공간을 어떻게 파악하지?
*
* 치즈가 녹는 경우: 치즈가 외부 공기와 2면이상 맞닿는 경우 한 시간안에 녹음
*
* 1) 외부 공기 여부 판단
* 2) 치즈가 외부 공기와 2면이상 맞닿았는지 판단
*
* 2과정을 반복
* */
