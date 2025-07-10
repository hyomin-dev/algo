package com.multi.baekjoon.simulation;


import java.io.*;

public class P_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toUpperCase();
        int[] array = new int[26];

        for(int i=0;i<str.length();i++){
            array[str.charAt(i)-65] +=1;
        }

        int maxIdx = 0;
        for(int i=1;i<26;i++){
            if(array[maxIdx]<array[i]){
                maxIdx = i;
            }
        }

        quickSort(array,0,25);

        if(array[0]==array[1])
            bw.write("?");
        else{
            bw.write(String.valueOf((char)(maxIdx+65)));
        }

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
            while(left<=end&&array[left]>=array[pivot])
                left++;

            while(right>start&&array[right]<=array[pivot])
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

        quickSort(array,start, right-1);
        quickSort(array,right+1,end);
    }


}
