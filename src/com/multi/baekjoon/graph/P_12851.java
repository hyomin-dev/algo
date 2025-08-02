package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_12851 {
    static int n,k;
    static int findTime = Integer.MAX_VALUE;
    static int count = 0; // 방법의 수
    static int[] visitedTime = new int[200000+1]; // 방문 시간
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(visitedTime, INF);

        bfs(n);

        bw.write(findTime+"\n");
        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int start){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0}); // 위치, 시간
        visitedTime[start] = 0;

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            if(node[0]==k){ // 동생을 찾은 경우
                if(node[1]<findTime){ // 동생을 찾은 시간이 기존에 찾은 시간보다 빠른 경우
                    findTime = node[1];
                    count = 1;
                }else if(node[1]==findTime){
                    count++;
                }

            }

            // x-1
            if(node[0]-1>=0&&visitedTime[node[0]-1]>=node[1]+1){ // x-1 >=0 and 더 짧은 시간 또는 같은 시간에 x-1을 방문할 수 있을 경우에만 x-1을 방문
                if(visitedTime[node[0]-1]>node[1]+1)
                    visitedTime[node[0]-1] = node[1]+1;
                queue.offer(new int[]{node[0]-1, node[1]+1});
            }

            // x+1
            if(node[0]+1<=200000&&visitedTime[node[0]+1]>=node[1]+1){ // x+1 <=200,000 and 더 짧은 시간 또는 같은 시간에 x+1을 방문할 수 있을 경우에만 x+1을 방문
                if(visitedTime[node[0]+1]>node[1]+1)
                    visitedTime[node[0]+1] = node[1]+1;
                queue.offer(new int[]{node[0]+1, node[1]+1});
            }


            // 2*x

            if(node[0]*2<=200000&&visitedTime[node[0]*2]>=node[1]+1){ // x+1 <=200,000 and 더 짧은 시간 또는 같은 시간에 x+1을 방문할 수 있을 경우에만 x+1을 방문
                if(visitedTime[node[0]*2]>node[1]+1)
                    visitedTime[node[0]*2] = node[1]+1;
                queue.offer(new int[]{node[0]*2, node[1]+1});
            }
        }

    }
}
