package com.multi.baekjoon.cumulative_sum_analysis;

import java.io.*;
import java.util.*;

public class P_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(br.readLine());

        int count = 0;

        Arrays.sort(array);

        int start =0;
        int end = array.length-1;

        while(start<end){

            if(array[start]+array[end]==x) {
                start++;
                count++;
            }

            // array[start] + array[end] < x --> start를 증가시켜서 두 수의 합을 키워야 됨
            while((start<n)&&(array[start]+array[end]<x))
                start++;

            if(start>=n)
                break;

            // array[start] + array[end] > x --> end를 감소시켜서 두 수의 합을 줄여야됨
            while(end>=0&&array[start]+array[end]>x)
                end--;

            if(end<0)
                break;
        }

        bw.write(count+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
