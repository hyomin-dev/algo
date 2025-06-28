package com.multi.baekjoon.graph;


import java.io.*;
import java.util.*;

public class P_1697 {

    static boolean[] visited = new boolean[100000+1];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {

        StringTokenizer st =new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int node) throws IOException {
        Queue<int[]> q = new LinkedList<>(); // node 위치, 걸리는 시간

        q.offer(new int[]{node,0});
        visited[node] = true;

        while(!q.isEmpty()){

            int[] currentX = q.poll();
            int currentNode = currentX[0];
            int currentTime = currentX[1];

            if(currentNode==k){
                bw.write(String.valueOf(currentTime));
                break;
            }

            if(currentNode-1 ==k || currentNode+1==k || currentNode*2==k){
                bw.write(String.valueOf(currentTime+1));
                break;
            }

            // node-1
            if(currentNode-1>=0&&!visited[currentNode-1]){
                q.offer(new int[]{currentNode-1,currentTime+1});
                visited[currentNode-1] = true;
            }

            // node+1
            if(currentNode+1<=100000&&!visited[currentNode+1]){
                q.offer(new int[]{currentNode+1,currentTime+1});
                visited[currentNode+1] = true;
            }

            // node*2
            if(currentNode*2<=100000&&!visited[currentNode*2]){
                q.offer(new int[]{currentNode*2, currentTime+1});
                visited[currentNode*2] = true;
            }

        }
    }
}





