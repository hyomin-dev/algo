package com.multi.baekjoon.time_complexity;

import java.io.*;
import java.util.*;

public class P_24263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(n+"\n");
        bw.write("1");

        bw.flush();
        bw.close();
        br.close();
    }
}
