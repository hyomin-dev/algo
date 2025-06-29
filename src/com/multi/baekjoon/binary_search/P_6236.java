package com.multi.baekjoon.binary_search;


import java.io.*;
import java.util.StringTokenizer;

public class P_6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n일, 1<= n <= 100,000
        int m = Integer.parseInt(st.nextToken()); // m번, 1<= m <=n

        int[] array = new int[n];
        int totalBudget=0;
        for(int i=0;i<n;i++) {
            array[i] = Integer.parseInt(br.readLine());
            totalBudget +=array[i];
        }



    }
}
