package com.multi.baekjoon.cumulative_sum_analysis;

import java.io.*;
import java.util.*;

public class P_29767 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] array = new long[n];

        st = new StringTokenizer(br.readLine());
        array[0] = Integer.parseInt(st.nextToken());
        for(int i=1;i<n;i++)
            array[i] = array[i-1] + Integer.parseInt(st.nextToken());


        for(int i=1;i<n;i++) {
            array[i] = array[i] + array[i-1];
        }

        Arrays.sort(array);

        long result = 0;
        int idx = n-1;
        while(k>0){
            result +=array[idx--];
            k--;
        }

        bw.write(result+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
