package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_15654 {

    static int n;
    static int m;
    static int[] array;
    static Stack<Integer> stack;
    static boolean[] visited;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(array);

        for(int i=0;i<n;i++){
            stack = new Stack<>();

            visited = new boolean[n];

            dfs(i);
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int node) throws IOException{

        visited[node] = true;
        stack.push(array[node]);

        if(stack.size()==m){
            ArrayList<Integer> list = new ArrayList<>(stack);
            for(int num: list)
                bw.write(num+" ");
            bw.newLine();
            return;
        }

        for(int i=0;i<n;i++){
           if(!visited[i]){

               dfs(i);
               visited[i] = false;
               stack.pop();

           }
        }
    }
}
