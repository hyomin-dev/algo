package com.multi.algo.day07.a_sorting;


import java.util.Arrays;

public class D_QuickSort2 {
    public static void main(String[] args) {

        int[] x = { 1, 5, 6, 8, 3, 2, 7, 9, 10, 11 };
        print(x);
        //quickSort(x,0,x.length-1);
        print(x);
    }

    public static void swap(int[] arr, int idx1, int idx2){
        int tmp;
        tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static <T> void swap(T[] arr, int idx1, int idx2){
        T tmp;
        tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static  void print(int[] arr){
        System.out.println("Array = "+ Arrays.toString(arr));
    }

    public static <T> void print(T[] arr){
        System.out.println("Array = "+ Arrays.toString(arr));
    }
}
