package com.multi.baekjoon.sort;


import java.io.*;
import java.util.StringTokenizer;

public class P_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] array = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        quickSort(array, 0, n-1);
        for(int i=0;i<n;i++){
            bw.write(array[i][0] + " "+array[i][1]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void quickSort(int[][] array, int start, int end){

        if(start>=end)
            return;

        int pivotIndex = start + (int)(Math.random()*(end-start+1));
        int[] tmp = array[pivotIndex];
        array[pivotIndex] = array[start];
        array[start] = tmp;
        int pivot = start;
        int left = start+1;
        int right = end;

        while(left<=right){
            while(left<=end&&(array[left][1]<array[pivot][1] || (array[left][1]==array[pivot][1] && array[left][0] <= array[pivot][0])))
                left++;
            while(right>start&&(array[right][1]>array[pivot][1] || (array[right][1]==array[pivot][1] && array[right][0] >= array[pivot][0])))
                right--;

            if(left>right){
                tmp = array[pivot];
                array[pivot] = array[right];
                array[right] = tmp;
            }else{
                tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }

        }

        quickSort(array, start, right-1);
        quickSort(array, right+1, end);


    }
}
