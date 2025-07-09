package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class P_10974 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static boolean[] visited;
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
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

        if(stack.size()==n){
            ArrayList<Integer> list = new ArrayList<>(stack);
            for(int num: list)
                bw.write(num+ " ");
            bw.newLine();
            return;
        }

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                stack.push(i);
                dfs(i);
                stack.pop();
                visited[i] = false;
            }
        }

    }
}
