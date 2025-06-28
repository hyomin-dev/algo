package com.multi.baekjoon.sort;


import java.io.*;

public class P_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(br.readLine());

        quickSort(array, 0, n-1);
        for(int i=0;i<n;i++){
            bw.write(String.valueOf(array[i]));
            bw.newLine();
        }

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
            while(left<=end&&array[left]<=array[pivot])
                left++;

            while(right>start&&array[right]>=array[pivot])
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

        quickSort(array,start,right-1);
        quickSort(array, right+1, end);

    }
}
