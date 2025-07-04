package com.multi.baekjoon.graph;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_13549 {

    static int n;
    static int k;
    static int result = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100000+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 0 <= n,k <= 100000
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited[n] = true;
        result = bfs(n);

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start,0});

        while(!q.isEmpty()){
            int[] x = q.poll();

            // 0초
            int sameTimeXPosition = x[0];
            for(int i=sameTimeXPosition;i<100000;sameTimeXPosition=i=sameTimeXPosition*2){
                if(!visited[i]){
                    if(i==k)
                        return x[1];
                    visited[i] = true;
                }
            }

            // ↓↓↓↓↓↓↓↓↓↓↓ 1초

            if(x[0]*2<=100000){
                q.offer(new int[]{2*x[0],x[1]});
            }

            // x-1
            if(x[0]-1>=0&&!visited[x[0]-1]) {
                q.offer(new int[]{x[0] - 1, x[1] + 1});
                visited[x[0]-1] = true;
            }

            // x+1
            if(x[0]+1<=100000&&!visited[x[0]+1]) {
                q.offer(new int[]{x[0] + 1, x[1] + 1});
                visited[x[0]+1] = true;
            }

        }
        return -1;

    }
}
