package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_15652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {

        // 1 <= m <= n <= 8

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

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

        if(stack.size()==m){
            ArrayList<Integer> list = new ArrayList<>(stack);
            for(int num: list)
                bw.write(num+" ");
            bw.newLine();
            return;
        }
        for(int i=node;i<=n;i++){
            stack.push(i);
            dfs(i);
            stack.pop();
        }
    }
}

/*
*
* 뒤에 나오는 숫자는 앞에 나온 숫자보다 같거나 커야한다.
*  stack ===> 1, 1, 1
*  stack ===> 1, 1, 2
*  stack ===> 1, 1, 3
*  statck ===> 1, 2, 2
* */


