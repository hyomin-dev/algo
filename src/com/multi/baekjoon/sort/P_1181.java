package com.multi.baekjoon.sort;


import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class P_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++)
            set.add(br.readLine());
        String[] array = set.toArray(new String[0]);

        quickSort(array, 0, array.length-1);

        for(int i=0;i<array.length;i++)
            bw.write(array[i]+"\n");
        bw.flush();
        bw.close();
        br.close();

    }
    static void quickSort(String[] array, int start, int end){
        if(start>=end)
            return;

        int pivotIndex = start +(int)(Math.random()*(end-start+1));
        String tmp = array[pivotIndex];
        array[pivotIndex] = array[start];
        array[start] = tmp;

        int pivot = start;
        int left = start+1;
        int right = end;

        while(left<=right){

            while(left<=end && ((array[left].length()<array[pivot].length()) || (array[left].length()==array[pivot].length() && array[left].compareTo(array[pivot])<=0 )))
                left++;

            while(right>start && ((array[right].length()>array[pivot].length()) || (array[right].length()==array[pivot].length() && array[right].compareTo(array[pivot])>=0 )))
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
