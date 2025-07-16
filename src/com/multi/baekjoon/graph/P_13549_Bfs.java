package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_13549_Bfs {
    static int n;
    static int k;
    static boolean[] visited = new boolean[100000+1];
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 0 <= n,k <= 100000
        n = Integer.parseInt(st.nextToken()); // 수빈 위치
        k = Integer.parseInt(st.nextToken()); // 동생 위치

        bfs(n);

        bw.write(String.valueOf(minTime));

        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int start){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{start,0});
        visited[start] = true;

        while(!q.isEmpty()){

            int[] node = q.poll();

            int now = node[0];
            int time = node[1];

            visited[now] = true;

            if(now==k&&time<minTime)
                minTime = time;

            if(now+1<=100000&&!visited[now+1]) {
                q.offer(new int[]{now+1,time+1});
            }

            if(now-1>=0&&!visited[now-1]){
                q.offer(new int[]{now-1,time+1});
            }

            if(2*now<=100000&&!visited[2*now]){
                q.offer(new int[]{2*now,time});
            }
        }
    }
}
