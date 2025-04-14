package com.multi.algo.day07.a_sorting;


import java.util.Arrays;

public class B_BubbleSort {
    public static void main(String[] args) {
        //버블 정렬은 기본적으로 배열의 두 수(
        //     a.b를 선택한 뒤, 만약 그 두 수가 정렬되었다면 놔두고 아니라면 두 수를 바꾸는 방식으로 진행된다.
        //     오름차순으로 정렬할 때는 a<b, 내림차순이라면 a>b여야 정렬된 것으로 판단한다. 이를 배열의 처음부터 끝까지 반복한다.

        int[] array = { 6, 4, 2, 1, 3, 5 }; //            5,4,3 ,2, 1, 0
        print(array);
//        for(int i =0;i<array.length;i++){
//            for(int j=1;j<array.length-i;j++){
//                if(array[j]<array[j-1])
//                    swap(array,j,j-1);
//            }
//        }

//        for(int i=0;i<array.length;i++){
//            for(int j=1;j<array.length-i;j++)
//                if(array[j]<array[j-1])
//                    swap(array,j,j-1);
//        }

//        for(int i=0;i<array.length;i++){
//            for(int j=array.length-1;j>i;j--)
//                if(array[j-1]<array[j])
//                    swap(array,j-1,j);
//        }

        for(int i= array.length-1;i>=0;i--){
            for(int j=0;j<i;j++)
                if(array[j]>array[j+1])
                    swap(array,j,j+1);
        }

        print(array);


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
