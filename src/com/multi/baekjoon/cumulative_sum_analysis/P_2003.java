package com.multi.baekjoon.cumulative_sum_analysis;


import java.io.*;
import java.util.*;

public class P_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());


        int end = 0;
        int count = 0;
        int intervalSum = 0;
        for(int start = 0; start<n;start++){
            while(intervalSum<m&&end<n){
                intervalSum +=array[end];
                end +=1;
            }

            if(intervalSum==m)
                count++;
            intervalSum -=array[start];
        }

        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
