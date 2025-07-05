package com.multi.baekjoon.brute_force;


import java.io.*;

public class P_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int digitNum = 1; // 초기 자릿수 1
        int digit = 10;

        for(int i=1;i<=n;i++){
            if(digit==i){
                digit = digit*10;
                digitNum++; // 자릿 수 증가
            }

            count +=digitNum;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
    }

}
