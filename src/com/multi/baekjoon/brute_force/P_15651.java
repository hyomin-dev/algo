package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.*;

public class P_15651 {

    static boolean[] visited;
    static Stack<Integer> stack;
    static int n;
    static int m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 <= m <= n <= 7
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1]; // node를 1부터 시작하기 위해

        for(int i=1;i<=n;i++){

            stack = new Stack<>();
            stack.push(i);
            dfs(i);

        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int node) throws IOException{
        visited[node] = true;

        if(stack.size()==m){
            List<Integer> list = new ArrayList<>(stack);

            for(int num: list)
                bw.write(num+" ");
            bw.newLine();
            return;
        }

        for(int i=1;i<=n;i++){
            stack.push(i);
            dfs(i);
            stack.pop();
        }
    }
}

/*
* 중복되는 수열을 여러 번 출력하면 안됨
* 수열은 사전 순으로 증가하는 순서로 출력
* */
