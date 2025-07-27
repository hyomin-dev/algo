package com.multi.baekjoon.cumulative_sum_analysis;

import java.io.*;
import java.util.*;

public class P_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 온도를 측정한 전체 날짜의 수, 2 <= n <= 100000
        int k = Integer.parseInt(st.nextToken()); // 합을 구하기 위한 연속적인 날짜의 수 1 < k < n

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            array[i]  = Integer.parseInt(st.nextToken());

        int sum = 0;

        for(int i=0;i<k;i++)
            sum +=array[i];

        int maxSum = sum;

        for(int i=k;i<n;i++){
            sum = sum -array[i-k] + array[i];
            if(sum>maxSum)
                maxSum = sum;
        }

        bw.write(maxSum+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
