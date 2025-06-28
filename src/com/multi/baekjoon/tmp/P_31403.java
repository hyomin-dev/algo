package com.multi.baekjoon.tmp;


import java.io.*;

public class P_31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int resultNum = a+b-c;
        int resultStr = Integer.parseInt(String.valueOf(a)+String.valueOf(b)) - c;

        bw.write(String.valueOf(resultNum));
        bw.newLine();
        bw.write(String.valueOf(resultStr));
        bw.flush();
        bw.close();
        br.close();

    }
}
