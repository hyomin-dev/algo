package com.multi.baekjoon.brute_force;

import java.io.*;
import java.util.StringTokenizer;

public class P_14500 {
    static int n,m;
    static int[][] matrix;
    static int maxValue = 0;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1}; // 상 우 하 좌
    static int[] dy = {-1,0,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 4<=n
        m = Integer.parseInt(st.nextToken()); // m<=500

        matrix = new int[n][m];
        visited = new boolean[n][m];
        for(int y=0;y<n;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0;x<m;x++){
                matrix[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int y=0;y<n;y++){
            for(int x=0;x<m;x++){
                visited[y][x] = true;
                checkAdjcency3(new int[]{x,y});
                search(new int[]{x,y}, matrix[y][x],1);
                visited[y][x] = false;
            }
        }

        bw.write(String.valueOf(maxValue));
        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int[] node,int sum, int depth){

        int nodeX = node[0];
        int nodeY = node[1];

        if(depth==4){
            if(sum>maxValue)
                maxValue=sum;
            return;
        }

        for(int d=0;d<4;d++){
            int sideX = nodeX+dx[d];
            int sideY = nodeY+dy[d];

            if(sideX<0 || sideX>=m || sideY<0 || sideY>=n)
                continue;
            if(visited[sideY][sideX])
                continue;

            visited[sideY][sideX] = true;
            search(new int[]{sideX,sideY},sum +matrix[sideY][sideX],depth+1);
            visited[sideY][sideX] = false;

        }

    }

    static void checkAdjcency3(int[] node){

        int nodeX = node[0];
        int nodeY = node[1];
        int nodeValue = matrix[nodeY][nodeX];

        // 위
        boolean isTop = false;
        int topValue=0;
        if(nodeY-1>=0) {
            isTop = true;
            topValue = matrix[nodeY-1][nodeX];
        }

        // 오른쪽
        boolean isRight = false;
        int rightValue=0;
        if(nodeX+1<m) {
            isRight = true;
            rightValue = matrix[nodeY][nodeX+1];
        }

        // 아래
        boolean isBottom = false;
        int bottomValue=0;
        if(nodeY+1<n) {
            isBottom = true;
            bottomValue = matrix[nodeY+1][nodeX];
        }

        // 왼쪽
        boolean isLeft = false;
        int leftValue=0;
        if(nodeX-1>=0) {
            isLeft = true;
            leftValue = matrix[nodeY][nodeX-1];
        }

        // 왼쪽 위 오른쪽
        if(isLeft&&isTop&&isRight){
            int sum = leftValue+topValue+rightValue+nodeValue;
            if(maxValue<sum)
                maxValue = sum;
        }

        // 왼쪽 아래 오른쪽
        if(isLeft&&isBottom&&isRight){
            int sum = leftValue+bottomValue+rightValue+nodeValue;
            if(maxValue<sum)
                maxValue = sum;
        }

        // 위 오른쪽 아래
        if(isTop&&isRight&&isBottom){
            int sum = topValue+rightValue+bottomValue+nodeValue;
            if(maxValue<sum)
                maxValue = sum;
        }



        // 위 왼쪽 아래
        if(isTop&&isLeft&&isBottom){
            int sum = topValue+leftValue+bottomValue+nodeValue;
            if(maxValue<sum)
                maxValue = sum;
        }

    }
}
