package com.multi.baekjoon.cumulative_sum_analysis;

 import java.io.*;
 import java.util.*;

public class P_2470 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 2 <= n <= 100,000
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(array);
        if(array[0]>=1){
            bw.write(array[0]+" "+array[1]);
        }else if(array[n-1]<=-1){
            bw.write(array[n-2]+" "+array[n-1]);
        }else{
            int minValue = Integer.MAX_VALUE;

            int end = n-1;
            ArrayList<int[]> list = new ArrayList<>();

            for(int start=0;start<n-1;start++){
                int sum = array[start] + array[end];
                int sumAbs = Math.abs(sum);
                if(sum==0){
                    list.add(new int[]{array[start], array[end]});
                    break;
                }

                if(sumAbs <minValue)
                    minValue = sumAbs;

                // Math.abs

                while(sum>0){

                }

            }
        }


    }
}

/*
서로 다른 두 용액을 혼합

산성 용액만 또는 알칼리성 용액만 섞어도 됨

두 용액의 특성은 오름차순으로 출력

0에 가까운 특성값이

* */
