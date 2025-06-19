package com.multi.baekjoon.pratice;


import java.io.*;

public class P_25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final String str = "long";

        int num = Integer.parseInt(br.readLine());

        for(int i =0; i<(num/4);i++){
            bw.write(str+" ");
        }
        bw.write("int");
        bw.close();
        br.close();

    }
}
