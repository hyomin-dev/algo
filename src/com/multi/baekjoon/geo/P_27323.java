package com.multi.baekjoon.geo;


import java.io.*;

public class P_27323 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(a*b));
        bw.flush();
        bw.close();
        br.close();
    }
}
