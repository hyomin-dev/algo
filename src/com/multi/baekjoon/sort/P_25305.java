package com.multi.baekjoon.sort;


import java.io.*;
import java.util.StringTokenizer;

public class P_25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());
        quickSort(array, 0, n-1);

        bw.write(String.valueOf(array[k-1]));
        bw.flush();
        bw.close();
        br.close();

    }

    static void quickSort(int[] array, int start, int end){

        if(start>=end)
            return;

        int pivot = start;
        int left = start+1;
        int right = end;

        while(left<=right){

            while(left<=end&&array[left]>=array[pivot])
                left++;

            while(right>start&&array[right]<=array[pivot])
                right--;

            if(left>right){
                int tmp = array[pivot];
                array[pivot] = array[right];
                array[right] = tmp;

            }else{
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

            }
        }

        quickSort(array, start, right-1);
        quickSort(array, right+1, end);
    }
}
