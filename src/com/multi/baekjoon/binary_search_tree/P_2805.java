package com.multi.baekjoon.binary_search_tree;


import java.io.*;
import java.util.StringTokenizer;

public class P_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] array = new int[n];
        int maxValue = -1;
        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(st.nextToken());
            if(maxValue<array[i])
                maxValue = array[i];
        }


       int start = 0;
       int end = maxValue;
       int h=0;
       int maxH = 0;
       while(start<=end){
           h = (start+end)/2;

           long sum=0;
           for(int i=0;i<n;i++)
               sum = sum+ Math.max(0, array[i]-h);

           if(sum>=m) { // 자른 나무 총 합이 가져갈 나무 길이보다 큰 경우 --> h를 늘려야함 --> 나무를 덜 자름
                start = h + 1;
                if(maxH<h)
                    maxH = h;
           }
           else // 자른 나무 총 합이 가져갈 나무 길이보다 작은 경우 --> h를 줄여야함 --> 나무를 더 자름
               end = h-1;

       }
        bw.write(String.valueOf(maxH));
        bw.flush();
        bw.close();
        br.close();
    }

}
