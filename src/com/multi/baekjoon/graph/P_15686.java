package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_15686 {

    static int n,m;
    static int[][] graph;
    static Data15686[] house = new Data15686[100];
    static Data15686[] chicken = new Data15686[26];
    static boolean[] visited;
    static int houseCount = 0, chickenCount=0;

    static int minValue = Integer.MAX_VALUE;
    static final int INF = (int)1e9;
    static int[][] distMatrix; // 모든 치킨집과 모든 집간의 치킨 거리
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1]; // 1부터 시작

        for(int y=1;y<=n;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=1;x<=n;x++){
                int num = Integer.parseInt(st.nextToken());
                if(num==1) {
                    house[houseCount] = new Data15686(x,y);
                    houseCount++;
                }
                else if(num==2) {
                    chicken[chickenCount] = new Data15686(x,y);
                    chickenCount++;
                }

                graph[y][x] = num;
            }
        }

        visited = new boolean[chickenCount]; // 치킨집 방문 여부
        distMatrix = new int[chickenCount][houseCount]; // 모든 치킨집과 모든 집간의 치킨 거리

        for(int i=0;i<chickenCount;i++){
            Data15686 nowChicken = chicken[i];
            for(int j=0;j<houseCount;j++){
                Data15686 nowHouse = house[j];
                int dist = Math.abs(nowChicken.x-nowHouse.x) + Math.abs(nowChicken.y-nowHouse.y);
                distMatrix[i][j] = dist;

            }
        }

        dfs(0,0);

        bw.write(minValue+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int index, int depth){
        if(depth==m){
            int sum = 0;
            for(int i=0;i<houseCount;i++){
                int eachMin = Integer.MAX_VALUE;
                for(int j=0;j<chickenCount;j++){
                    if(!visited[j])
                        continue;
                    if(distMatrix[j][i]<eachMin)
                        eachMin = distMatrix[j][i];
                }
                sum += eachMin;
            }

            if(sum<minValue) // 지금까지 dfs를 이용해 계산한 도시의 치킨 거리를 비교
                minValue = sum;

            return;
        }

        for(int i=index;i<chickenCount;i++){
            if(!visited[i]){
                visited[i] = true; // i번째 치킨집을 추가
                dfs(i+1,depth+1);
                visited[i] = false;

            }
        }
    }
}

class Data15686{
    int x;
    int y;

    public Data15686(int x, int y){
        this.x = x;
        this.y = y;
    }
}

/*
집 리스트, 치킨 집 리스트

각 치킨 집에서 모든 집까지의 치킨 거리 계산하면서 갱신을 한다.

* */


