package com.multi.baekjoon.simulation;

import java.io.*;
import java.util.*;

public class P_15439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(n*n-n+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
