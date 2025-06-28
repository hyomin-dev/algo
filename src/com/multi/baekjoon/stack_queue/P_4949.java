package com.multi.baekjoon.stack_queue;


import java.io.*;
import java.util.Stack;

public class P_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String input = br.readLine();
            if(input.equals("."))
                break;

            String[] strArray = input.split("");

            Stack<String> stack = new Stack<>();
            String result = "yes";
            for(String ps: strArray){

                if(ps.equals("("))
                    stack.push(ps);
                else if(ps.equals("["))
                    stack.push(ps);
                else if(ps.equals(")")){
                    if(stack.isEmpty()){
                        result = "no";
                        break;
                    } else if(stack.peek().equals("[")){
                        result = "no";
                        break;
                    } else{
                        stack.pop();
                    }
                }else if(ps.equals("]")){
                    if(stack.isEmpty()){
                        result = "no";
                        break;
                    } else if(stack.peek().equals("(")){
                        result = "no";
                        break;
                    } else{
                        stack.pop();
                    }
                }else
                    continue;
            }

            if(!stack.isEmpty())
                result = "no";

            bw.write(result);
            bw.newLine();

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
