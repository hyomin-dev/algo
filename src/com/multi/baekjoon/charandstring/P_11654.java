package com.multi.baekjoon.charandstring;


import java.io.*;

public class P_11654 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        bw.write(String.valueOf((int)str.charAt(0)));

        bw.flush();
        bw.close();
        br.close();
    }
}
