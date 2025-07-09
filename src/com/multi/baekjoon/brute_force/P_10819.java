package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_10819 {
    static int n;
    static int[] array;
    static int maxValue = 0;
    static Stack<Integer> stack;
    static boolean[] visited;
    static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {


        n = Integer.parseInt(br.readLine()); // 3 <= n <=8
        StringTokenizer st = new StringTokenizer(br.readLine());

        array = new int[n];
        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            stack = new Stack<>();
            stack.push(array[i]);
            visited = new boolean[n];
            dfs(i);
        }

        bw.write(String.valueOf(maxValue));
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int index){
        visited[index] = true;

        if(stack.size()==n){
            ArrayList<Integer> list = new ArrayList<>(stack);
            int sum =0;
            for(int i=0;i<n-1;i++){
                sum +=Math.abs(list.get(i)-list.get(i+1));
            }
            if(sum>maxValue)
                maxValue = sum;
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                stack.push(array[i]);
                dfs(i);
                stack.pop();
                visited[i] = false;
            }
        }
    }

}
