package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.StringTokenizer;

public class P_15650 {


    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int m;
    public static boolean[] visited;
    public static int[] results;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        results = new int[m+1]; // 0 초기화

        dfs(1);
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int depth) throws IOException {
        if(depth>m){
            for(int i=1;i<=m;i++){
                bw.write(results[i]+" ");
            }
            bw.newLine();
            bw.flush();
            return;
        }

        for(int i=1;i<=n;i++){
            if(!visited[i]&&results[depth-1]<i){
                visited[i] = true;
                results[depth] = i;
                dfs(depth+1);
                visited[i] = false;
                results[depth] = 0;
            }
        }

    }
}
