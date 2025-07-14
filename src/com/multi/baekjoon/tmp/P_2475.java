package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.StringTokenizer;

public class P_2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum=0;
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            sum +=n*n;
        }

        bw.write(String.valueOf(sum%10));
        bw.flush();
        bw.close();
        br.close();

    }
}
