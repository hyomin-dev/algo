package com.multi.baekjoon.tmp;


import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P_10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a = new BigInteger(st.nextToken());
        bw.write(a.add(new BigInteger(st.nextToken())).toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
