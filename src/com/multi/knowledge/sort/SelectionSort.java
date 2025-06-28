package com.multi.knowledge.sort;


import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 4, 8};


        for(int i=0;i<array.length-1;i++){
            int minIdx = i;
            for(int j=i+1;j<array.length;j++){
                if(array[minIdx] > array[j])
                    minIdx = j;
            }
           swap(array, i, minIdx);
        }

        System.out.println(Arrays.toString(array));
    }

    static void swap(int[] array, int x1, int x2){
        int tmp = array[x1];
        array[x1] = array[x2];
        array[x2] = tmp;
    }

}
