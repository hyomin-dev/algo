package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_6603 {
    static int[] array;
    static boolean[] visited;
    static int k;
    static Stack<Integer> stack;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        boolean isNotFirst = false;
        while(true){
            if(isNotFirst){
                bw.newLine();
            }else{
                isNotFirst = true;
            }


            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken()); // 6 < k < 13
            if(k==0)
                break;
            array = new int[k];
            for(int i=0;i<k;i++)
                array[i] = Integer.parseInt(st.nextToken());

            for(int i=0;i<=k-6;i++){
                visited = new boolean[k];
                stack = new Stack<>();
                stack.push(array[i]);
                visited[i] = true;
                dfs(i);
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int index) throws IOException{

        if(stack.size()==6){
            ArrayList<Integer> list = new ArrayList<>(stack);
            for(int num : list){
                bw.write(num+" ");
            }
            bw.newLine();
            return;
        }

        for(int i=index;i<k;i++){
            if(!visited[i]){
                visited[i] = true;
                stack.push(array[i]);
                dfs(i);
                stack.pop();
                visited[i] = false;
            }
        }

    }
}
