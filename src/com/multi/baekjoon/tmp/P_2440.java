package com.multi.baekjoon.tmp;


import java.io.*;

public class P_2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=n;i>0;i--){
            for(int j=0;j<i;j++)
                bw.write("*");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
