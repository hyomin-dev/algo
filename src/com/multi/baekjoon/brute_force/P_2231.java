package com.multi.baekjoon.brute_force;


import java.io.*;

public class P_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=1;i<=n;i++){
            String str = String.valueOf(i);
            int sum = i;
            for(int j=0;j<str.length();j++)
                sum += Integer.parseInt(String.valueOf(str.charAt(j)));
            if(sum==n){
                result = i;
                break;
            }

        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
* 자연수 M의 분해합=N인 경우, N의 생성자 = M
* M의 분해합 = M+ M을 구성하는 자리수의 합
* */
