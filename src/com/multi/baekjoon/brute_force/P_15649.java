package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.StringTokenizer;

public class P_15649{

    public static int n;
    public static int m;
    public static int[] results;
    public static boolean[] visited;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 1~n까지의 자연수
        m = Integer.parseInt(st.nextToken()); // n개의 자연수 중에 m개를 중복 없이 뽑음
        results = new int[m+1]; // 출력할 숫자들을 담는 정수
        visited = new boolean[n+1]; // 방문한 노드(자연수)를 체크


        dfs(1);
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int depth) throws IOException{

        if(depth>m){
            for(int i=1;i<=m;i++){
                bw.write(results[i]+" ");
            }
            bw.newLine();
            return;
        }

        for(int i=1;i<=n;i++)
            if(!visited[i]){
                results[depth] = i;
                visited[i] = true;
                dfs(depth+1);
                visited[i] = false;
            }

    }
}


/*
* nPm을 찾는 순열 문제
* */
