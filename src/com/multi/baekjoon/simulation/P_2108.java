package com.multi.baekjoon.simulation;

import java.io.*;
import java.util.*;

public class P_2108 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // n은 홀수

        int[] array = new int[n];

        int[] countArray = new int[8001]; // -4000 <= 정수 <= 4000 --> 4000-(-4000) +1 = 8001개, -4000 --> idx는 0, 4000 --> idx는 8000
        for(int i=0;i<n;i++) {
            array[i] = Integer.parseInt(br.readLine());
            countArray[array[i]+4000]++;
        }

        Arrays.sort(array);

        int sum = 0;
        for(int i=0;i<n;i++)
            sum +=array[i];

        bw.write((int)Math.round(((double)sum/n))+"\n"); // 산술 평균

        bw.write(array[n/2]+"\n"); // 중앙값

       int maxCount = 0;
       boolean isFirst = true;
       int result = array[0];

       for(int i=0;i<8001;i++){
           if(maxCount < countArray[i]){
               maxCount = countArray[i];
               isFirst = true;
               result = i-4000;
           }else if(maxCount==countArray[i]&&isFirst){
               result = i-4000;
               isFirst = false;
           }
       }

        bw.write(result+"\n"); // 최빈값

        bw.write(array[n-1]-array[0]+"");

        bw.flush();
        bw.close();
        br.close();

    }
}

/*
* 반례
*
5
100
1
1
2
2
* */