package com.multi.baekjoon.sort;


import java.io.*;
import java.util.StringTokenizer;

public class P_10814 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] nameArray = new String[n];
        int[][] array = new int[n][2]; // 나이, 가입 순서
        for(int i =0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = i;
            nameArray[i] = st.nextToken();
        }

        quickSort(array, 0, n-1);

        for(int i=0;i<n;i++){
            bw.write(array[i][0]+" "+nameArray[array[i][1]]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void quickSort(int[][] array, int start, int end){

        if(start>=end)
            return;

        int randomIndex = start + (int)(Math.random()*(end-start+1));
        int[] tmp = array[randomIndex];
        array[randomIndex] = array[start];
        array[start] = tmp;

        int pivot = start;
        int left = start+1;
        int right = end;

        while(left<=right){

            while(left<=end && ((array[left][0] <array[pivot][0])||(array[left][0]==array[pivot][0]&&array[left][1]<=array[pivot][1])))
                left++;

            while(right>start && ((array[right][0]>array[pivot][0])||(array[right][0]==array[pivot][0] && array[right][1]>=array[pivot][1])))
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
