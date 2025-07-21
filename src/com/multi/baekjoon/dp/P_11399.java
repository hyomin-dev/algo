package com.multi.baekjoon.dp;

import java.io.*;
import java.util.*;

public class P_11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());

        quickSort(array,0,n-1);

        for(int i=1;i<n;i++){
            array[i] = array[i]+ array[i-1];
        }

        int sum = 0;
        for(int i=0;i<n;i++)
            sum +=array[i];

        bw.write(sum+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static void quickSort(int[] array, int start, int end){
        if(start>=end)
            return;

        int randomIdx = start + (int)(Math.random()*(end-start+1));

        int tmp = array[randomIdx];
        array[randomIdx] = array[start];
        array[start] = tmp;

        int pivot = start;
        int left = start+1;
        int right = end;

        while(left<=right){

            while(left<=end&&array[left]<=array[pivot])
                left++;

            while(right>start&&array[right]>=array[pivot])
                right--;

            if(left>right){
                tmp = array[right];
                array[right] = array[pivot];
                array[pivot] = tmp;
            }else{
                tmp = array[right];
                array[right] = array[left];
                array[left] = tmp;
            }
        }

        quickSort(array,start,right-1);
        quickSort(array,right+1,end);

    }
}
