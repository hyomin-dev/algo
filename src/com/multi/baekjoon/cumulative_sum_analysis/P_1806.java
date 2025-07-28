package com.multi.baekjoon.cumulative_sum_analysis;

import java.io.*;
import java.util.*;

public class P_1806 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());

        int end = -1;
        int intervalSum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int start=0;start<n;start++){

            while(intervalSum<s&&end<n){
                end++;
                if(end==n){
                    end--;
                    break;
                }
                intervalSum +=array[end];
            }

            if(intervalSum>=s){
                int length = end-start+1;
                if(length<minLength)
                    minLength = length;
            }

            intervalSum -=array[start];

        }

        if(minLength==Integer.MAX_VALUE)
            bw.write("0");
        else
            bw.write(minLength+"");

        bw.flush();
        bw.close();
        br.close();

    }

}

