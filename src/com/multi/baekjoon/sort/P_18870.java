package com.multi.baekjoon.sort;


import java.io.*;
import java.util.*;

public class P_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(st.nextToken());
            set.add(array[i]);
        }

        Integer[] notDuplArray = set.toArray(new Integer[0]);

        quickSort(notDuplArray, 0, notDuplArray.length-1);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<notDuplArray.length;i++)
            map.put(notDuplArray[i],i);

        for(int i=0;i<n;i++){
            bw.write(map.get(array[i])+" ");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static void quickSort(Integer[] notDuplArray, int start, int end){

        if(start>=end)
            return;

        int randomIndex = start+ (int)(Math.random()*(end-start+1));
        int tmp = notDuplArray[randomIndex];
        notDuplArray[randomIndex] = notDuplArray[start];
        notDuplArray[start] = tmp;

        int pivot = start;
        int left = start+1;
        int right = end;

        while(left<=right){

            while(left<=end&& notDuplArray[left]<= notDuplArray[pivot])
                left++;

            while(right>start && notDuplArray[right]>=notDuplArray[pivot])
                right--;

            if(left>right){
                tmp = notDuplArray[pivot];
                notDuplArray[pivot] = notDuplArray[right];
                notDuplArray[right] = tmp;
            }else{
                tmp = notDuplArray[left];
                notDuplArray[left] = notDuplArray[right];
                notDuplArray[right] = tmp;
            }
        }

        quickSort(notDuplArray, start, right-1);
        quickSort(notDuplArray, right+1, end);

    }
}
