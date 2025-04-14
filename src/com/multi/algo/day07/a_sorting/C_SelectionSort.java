package com.multi.algo.day07.a_sorting;


import java.util.Arrays;

public class C_SelectionSort {
    public static void main(String[] args) {

        //선택 정렬은 정렬되지 않은 데이터들에 대해 가장 작은 데이터를 찾아 가장 앞의 데이터와 교환해나가는 방식
        //for i = 0 to n:
        //  a[i]부터 a[n - 1]까지 차례로 비교하여 가장 작은 값이 a[j]에 있다고 하자.
        //        a[i]와 a[j]의 값을 서로 맞바꾼다.

        int[] arr = { 3, 4, 5, 1, 2, 6 };
        print(arr);
        selectionSort(arr);
        print(arr);
    }

    private static void selectionSort(int[] arr) {

        for(int i=0;i<arr.length-1;i++){
            int minIdx = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minIdx]>arr[j])
                    minIdx = j;
            }
            swap(arr,minIdx,i);
        }
    }

    public static  void swap(int[] arr, int idx1, int idx2){
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
