package com.multi.algo.day07.a_sorting;


import java.util.Arrays;

public class A_SwapTest2 {
    public static void main(String[] args) {
        int[] num = {6, 1, 2, 3, 5, 9};
        System.out.println(Arrays.toString(num));
        swap(num,0,5);
        System.out.println(Arrays.toString(num));
    }

    public static void swap(int[] arr, int idx1, int idx2){
        int tmp;
        tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

}
