package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_18290 {

    static int n;
    static int m;
    static int k;
    static int[][] array;
    static boolean[][] visited;
    static int[][] blocked;
    static int result;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());


        // 1 <= n,m <= 10
        n = Integer.parseInt(st.nextToken()); // row
        m = Integer.parseInt(st.nextToken()); // column

        // 1 <= k <= min(4, nxm)
        k = Integer.parseInt(st.nextToken());

        if(n==1&&m==1){ // 1x1
            result = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(result));
        }else{

            result = -10000*k; // k개를 선택했을 때 가장 작은 수

            array = new int[n][m];
            for(int y=0;y<n;y++){
                st = new StringTokenizer(br.readLine());
                for(int x=0;x<m;x++){
                    array[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[n][m];
            blocked = new int[n][m];
            dfs(0,0);

            bw.write(String.valueOf(result));

        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int sum, int selectCount){

        if(selectCount==k){
            if(sum> result)
                result = sum;
            return;
        }

        for(int y=0;y<n;y++){
            for(int x=0;x<m;x++){
                setBlock(x, y);
                if(!visited[y][x]&&blocked[y][x]==0){
                    visited[y][x] = true;
                    sum +=array[y][x];
                    selectCount +=1;
                    dfs(sum,selectCount);
                    sum -=array[y][x];
                    selectCount -=1;
                    visited[y][x] = false;
                }
                // selectCount==0이면, 처음 방문하는 것 ==> 다시 방문 안하도록
                if(selectCount==0)
                    visited[y][x] = true;
                setUnBlock(x, y);

            }
        }
    }

    static void setBlock(int x,int y){

        //top
        if(y-1>=0) // false인 경우만
            blocked[y-1][x] += 1;

        //right
        if(x+1<m)
            blocked[y][x+1] += 1;

        //bottom
        if(y+1<n)
            blocked[y+1][x] += 1;

        //left
        if(x-1>=0)
            blocked[y][x-1] += 1;

    }

    static void setUnBlock(int x,int y){

        //top
        if(y-1>=0)
            blocked[y-1][x] -= 1;

        //right
        if(x+1<m)
            blocked[y][x+1] -= 1;

        //bottom
        if(y+1<n)
            blocked[y+1][x] -= 1;

        //left
        if(x-1>=0)
            blocked[y][x-1] -= 1;

    }

}
