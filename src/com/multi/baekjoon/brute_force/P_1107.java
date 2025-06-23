package com.multi.baekjoon.brute_force;


import java.io.*;

public class P_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());

       // n이 100인 경우
        if(n==100)
            bw.write("0");


        bw.flush();
        bw.close();
        br.close();

    }
}
