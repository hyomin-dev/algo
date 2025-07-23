package com.multi.baekjoon.time_complexity;

import java.io.*;
import java.util.*;

public class P_24264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        bw.write(n*n+"\n");
        bw.write("2");

        bw.flush();
        bw.close();
        br.close();

    }
}
