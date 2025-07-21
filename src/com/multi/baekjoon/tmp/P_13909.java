package com.multi.baekjoon.tmp;


import java.io.*;

public class P_13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        /*
        * 약수의 개수가 짝수: 닫힘
        * 약수의 개수가 홀수: 열림
        * */

        /*
         * rootN * rootN == N 인 경우는 약수의 개수는 홀수
         * rootN * rootN != N 인 경우는 약수의 개수는 짝수
         * */


        int rootN = (int)Math.sqrt(n);

        bw.write(String.valueOf(rootN));

        bw.flush();
        bw.close();
        br.close();

    }
}
