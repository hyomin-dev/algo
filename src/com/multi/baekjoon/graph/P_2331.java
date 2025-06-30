package com.multi.baekjoon.graph;


import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class P_2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        stack.push(a);
        while(true){

            int num = stack.peek();
            int nextNum = calNext(num, p);
            if(stack.contains(nextNum)){
                while(true){
                    if(stack.pop()==nextNum)
                        break;
                }
                break;
            }else{
                stack.push(nextNum);
            }
        }

        bw.write(String.valueOf(stack.size()));
        bw.flush();
        bw.close();
        br.close();

    }

    static int calNext(int num, int p){

        int sum = 0;

        String numStr = String.valueOf(num);

        for(int i=0;i<numStr.length();i++){
            int result = 1;
            for(int j=0;j<p;j++)
                result = result * Integer.parseInt(numStr.charAt(i)+"");
            sum +=result;
        }
        return sum;

    }
}

/*
*
* A=57, P=2인 경우 D[1] = 57, D[2] = 25+49 = 74, D[3] = 49+16 = 65, ... D[13] = 1+36 = 37, D[14] = 9+49 = 58, D[15] = 25+64 = 89
* */
