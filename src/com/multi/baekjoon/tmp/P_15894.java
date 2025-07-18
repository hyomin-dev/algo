package com.multi.baekjoon.tmp;


import java.io.*;

public class P_15894 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        bw.write(String.valueOf(n*4));

        bw.flush();
        bw.close();
        br.close();

    }
}

/*

추가 되는 둘레: n+2+1
차감 되는 둘레: n-1

직전 둘레 + 추가되는 둘레 - 차감되는 둘레

n=1 --> 4
n=2 --> 4 + (2+2+1) - (1) = 8
n=3 --> 8 + (3+2+1) - (3-1) = 12


An = An-1 + (n+2+1) - (n-1) = An-1 +4

A1 = 4
A2 = 8
A3 = 12
A4 = 16

즉 An = 4n;

* */
