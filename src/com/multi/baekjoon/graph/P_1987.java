package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_1987 {

    static int r, c;
    static char[][] graph;
    static boolean[] visited = new boolean[26];
    static int[] dx = new int[]{0,0,-1,1}; // 상 하 좌 우
    static int[] dy = new int[]{-1,1,0,0}; //상 하 좌 우
    static int maxValue = 1;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];

        for(int y=0;y<r;y++){
            String s = br.readLine();
            for(int x=0;x<c;x++){
                graph[y][x] = s.charAt(x);
            }
        }

        visited[graph[0][0]-'A'] = true;
        dfs(new int[]{0,0},1);

        bw.write(maxValue+"");
        bw.flush();
        bw.close();
        br.close();

//        System.out.println((int)'A'); // 65
//        System.out.println((int)'Z'); // 90

    }

    static void dfs(int[] node, int depth){
        if(depth>maxValue)
            maxValue = depth;

        for(int i=0;i<4;i++){
            int moveX = node[0] + dx[i];
            int moveY = node[1] + dy[i];

            if(moveX<0 || moveX >=c || moveY <0 || moveY>=r)
                continue;

            if(!visited[graph[moveY][moveX]-'A']){
                visited[graph[moveY][moveX]-'A'] = true;
                dfs(new int[]{moveX,moveY},depth+1);
                visited[graph[moveY][moveX]-'A'] = false;

            }
        }
    }
}
