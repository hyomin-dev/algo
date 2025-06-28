package com.multi.baekjoon.sort;


import java.io.*;

public class P_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strArray = br.readLine().split("");
        int[] array = new int[strArray.length];
        for(int i =0;i<strArray.length;i++)
            array[i] = Integer.parseInt(strArray[i]);

        quickSort(array, 0, array.length-1);

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<array.length;i++)
            stringBuilder.append(array[i]);

        bw.write(stringBuilder.toString());
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
