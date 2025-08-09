package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_2239 {

    static int[][] graph = new int[10][10]; // 인덱스 1부터 시작하기 위함
    static ArrayList<int[]> blankList = new ArrayList<>();
    static int zeroCount = 0;
    static int[] countArray = new int[10]; // 0이 아닌 것의 개수
    static boolean isFind = false;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{

        for(int y=1;y<=9;y++){
            String s = br.readLine();
            for(int x=1;x<=9;x++){
                graph[y][x] = s.charAt(x-1) - '0';
                if(graph[y][x]==0) {
                    blankList.add(new int[]{x,y});
                    zeroCount++;
                }

            }
        }

        search(0);

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean checkRow(int row, int num){
        for(int x=1;x<=9;x++){
            if(graph[row][x]==num)
                return true;
        }
        return false;
    }

    static boolean checkColumn(int col, int num){

        for(int y=1;y<=9;y++){
           if(graph[y][col]==num)
               return true;
        }

        return false;
    }

    static boolean checkMinBox(int x, int y,int num){

        // 123 -> 1, 456 -> 4, 789 ->7

        int startX, startY;
        if(x<=3)
            startX = 1;
        else if(x<=6)
            startX = 4;
        else
            startX = 7;

        if(y<=3)
            startY = 1;
        else if(y<=6)
            startY = 4;
        else
            startY = 7;

        for(int yy=startY;yy<=startY+2;yy++){
            for(int xx=startX;xx<=startX+2;xx++)
               if(graph[yy][xx]==num)
                   return true;
        }
        return false;

    }

    static void search(int depth) throws IOException{
        if(depth==zeroCount){

            for(int y=1;y<=9;y++){
                for(int x=1;x<=9;x++){
                    bw.write(graph[y][x]+"");
                }
                bw.newLine();
            }

            isFind = true;

            return;
        }

        int[] now = blankList.get(depth);
        for(int num=1;num<=9;num++){
            if(isFind)
                return;

            if(checkRow(now[1],num))
                continue;
            if(checkColumn(now[0],num))
                continue;
            if(checkMinBox(now[0], now[1], num))
                continue;

            graph[now[1]][now[0]] = num;
            search(depth+1);
            graph[now[1]][now[0]] = 0;

        }
    }
}
/*


* */
