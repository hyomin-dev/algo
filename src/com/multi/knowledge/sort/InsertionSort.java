package com.multi.knowledge.sort;


import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for(int i=1;i<array.length;i++){
            for(int j=i-1;j>=0;j--){
                if(array[j]>array[j+1]){ // 초기에는 j+1이 key임, 왼쪽으로 이동하면서 key도 같이 이동함
                    swap(array, j+1,j);
                }else
                    break;

            }
        }
        System.out.println(Arrays.toString(array));


    }

    private static void swap(int[] array, int candidate, int j) {
        int tmp = array[candidate];
        array[candidate] = array[j];
        array[j] = tmp;
    }
}
