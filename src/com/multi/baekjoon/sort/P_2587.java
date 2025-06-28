package com.multi.baekjoon.sort;


import java.io.*;

public class P_2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array = new int[5];
        for(int i=0;i<5;i++)
            array[i] = Integer.parseInt(br.readLine());

        quickSort(array,0, 5-1);

        int sum = 0;

        for(int i=0;i<5;i++)
            sum +=array[i];

        // 0 1 2 3 4
        // 홀수: 5/2

        // 0 1 2 3 4 5
        // 짝수: 6/2

        bw.write(String.valueOf(sum/5));
        bw.newLine();
        bw.write(String.valueOf(array[5/2]));

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

        quickSort(array,start, right-1);
        quickSort(array,right+1, end);
    }
}
