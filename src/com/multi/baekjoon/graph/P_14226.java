package com.multi.baekjoon.graph;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class P_14226 {
    static int s;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = Integer.parseInt(br.readLine()); // 2 <= s <= 1000

        bfs(1);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});

        while(!q.isEmpty()){
            int[] x = q.poll();
            if(x[0]==s){
                result = x[1];
                break;
            }

        }
    }
}
