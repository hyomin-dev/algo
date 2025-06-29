package com.multi.baekjoon.brute_force;


import java.io.*;

public class P_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int max3 = (int)Math.ceil(n/3.0);
        int max5 = (int)Math.ceil(n/5.0);

        for(int i=0;i<=max3;i++){
            for(int j=0;j<=max5;j++){
                if(5*j+3*i==n){
                    bw.write(String.valueOf(i+j));
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
            }
        }

        bw.write("-1");
        bw.flush();
        bw.close();
        br.close();

    }
}
