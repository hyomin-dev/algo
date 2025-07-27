package com.multi.baekjoon.cumulative_sum_analysis;

import java.io.*;
import java.util.*;

public class P_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 <= x <= n <= 250,000
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int accumulatedSum = 0;
        int count = 0;
        int maxSum = 0;

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<x;i++)
            accumulatedSum +=array[i];

        maxSum = accumulatedSum;

        if(accumulatedSum!=0)
            count =1;

        for(int i=x;i<n;i++){
            accumulatedSum = accumulatedSum - array[i-x] + array[i];
            if(accumulatedSum==maxSum){
                count++;
            }else if(accumulatedSum>maxSum){
                maxSum = accumulatedSum;
                count = 1;
            }
        }

        if(maxSum ==0){
            bw.write("SAD");
        }else{
            bw.write(maxSum+"\n");
            bw.write(count+"");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
/*
250*10^3 * 8*10^3 = 250*8 * 10^6 = 2000 * 10^6 = 2*10^9

* */
