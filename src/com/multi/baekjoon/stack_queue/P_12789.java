package com.multi.baekjoon.stack_queue;


import java.io.*;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> q = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            q.offer(Integer.parseInt(st.nextToken()));

        int start =1;
        boolean isPossible = true;
        while(true){

            if(start>n)
                break;

            if(!q.isEmpty()&&q.peek()==start) {
                q.poll();
                start++;
            }else if(!stack.isEmpty()&&stack.peek()==start){
                stack.pop();
                start++;
            }else if(!q.isEmpty()){
                stack.push(q.poll());
            }else{
                isPossible = false;
                break;
            }
        }

        if(isPossible)
            bw.write("Nice");
        else
            bw.write("Sad");

        bw.flush();
        bw.close();
        br.close();
    }
}
