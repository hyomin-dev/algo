package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_16953 {
    static int a, b;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int result = bfs(a);

        bw.write(result+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(int start){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start,0});

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            if(node[0]==b)
                return node[1]+1;
            if(node[0]>(int)1e9)
                break;

            // 2를 곱함
            if(node[0]*2<=(int)1e9)
                queue.offer(new int[]{node[0]*2,node[1]+1});

            // 1을 수의 가장 오른쪽에 추가
            String numStr = node[0]+"1";
            if(numStr.length()<=9)
                queue.offer(new int[]{Integer.parseInt(numStr),node[1]+1});

        }
        return -1;

    }
}
