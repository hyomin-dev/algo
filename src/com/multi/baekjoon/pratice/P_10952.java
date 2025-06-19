package com.multi.baekjoon.pratice;


import java.io.*;
import java.util.StringTokenizer;

public class P_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if(num1+num2==0)
                break;

            bw.write(String.valueOf(num1+num2));
            bw.newLine();

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
