package com.multi.baekjoon.time_complexity;

import java.io.*;
import java.util.*;

public class P_24267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        long result = n*(n-1)*(n-2)/6;
        bw.write(result+"\n");
        bw.write("3");

        bw.flush();
        bw.close();
        br.close();

    }
}
