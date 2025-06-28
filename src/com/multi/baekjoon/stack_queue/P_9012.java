package com.multi.baekjoon.stack_queue;


import java.io.*;
import java.util.Stack;


public class P_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int i =0;
        while(i<t){

            Stack<String> stack = new Stack<>();
            String result = "YES";
            String[] strArray = br.readLine().split("");

            for(String ps: strArray){

                if(ps.equals("("))
                    stack.push(ps);
                else{
                    if(stack.isEmpty()){
                        result = "NO";
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty())
                result = "NO";

            bw.write(result);
            bw.newLine();

            i++;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
/*
* (: 스택에 쌓는다
* ): 스택에서 하나를 뺀다.
* */
