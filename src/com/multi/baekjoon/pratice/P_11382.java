package com.multi.baekjoon.pratice;


import java.io.*;
import java.util.StringTokenizer;

public class P_11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Long sum=0L;
        while(st.hasMoreTokens())
            sum = sum + Long.parseLong(st.nextToken());

        bw.write(sum+"");
        bw.close();
        br.close();
    }
}
