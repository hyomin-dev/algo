package com.multi.algo.day07.a_sorting;


import java.sql.SQLOutput;
import java.util.Arrays;

public class A_SwapTest3 {
    public static void main(String[] args) {
        String[] str = {"햄버거", "샌드위치", "커피"};
        print(str);
        swap(str,0,1);
        print(str);
        //"str배열"에 있는 것 중에서 "0번째 위치"와 "1번째 위치"를 바꾸어라.
    }

    public static <T> void swap(T[] arr, int idx1, int idx2){
        T tmp;
        tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static <T> void print(T[] arr){
        System.out.println("Array = "+Arrays.toString(arr));
    }

}
