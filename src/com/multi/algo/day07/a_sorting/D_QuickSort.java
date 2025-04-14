package com.multi.algo.day07.a_sorting;


import java.util.Arrays;

public class D_QuickSort {

    //리스트 가운데서 하나의 원소를 고른다. 이렇게 고른 원소를 피벗이라고 한다.
    //피벗 앞에는 피벗보다 값이 작은 모든 원소들이 오고, 피벗 뒤에는 피벗보다 값이 큰 모든 원소들이 오도록 피벗을 기준으로 리스트를 둘로 나눈다.
    // 이렇게 리스트를 둘로 나누는 것을 분할이라고 한다. 분할을 마친 뒤에 피벗은 더 이상 움직이지 않는다.
    //분할된 두 개의 작은 리스트에 대해 재귀(Recursion)적으로 이 과정을 반복한다. 재귀는 리스트의 크기가 0이나 1이 될 때까지 반복된다.

    public static void main(String[] args) {
        int[] x = { 1, 5, 6, 8, 3, 2, 7, 9, 10, 11 };
        print(x);
        quickSort(x,0,x.length-1);
        print(x);



    }

    public static void quickSort(int[] arr, int left, int right){

        int pl = left; // 왼쪽 커서
        int pr = right; // 오른쪽 커서

        int pivot = arr[(pl+pr)/2]; // 가운데를 pivot으로

        do{
            while(arr[pl]<pivot) pl++; // 왼쪽에서 피벗방향으로 인덱스를 증가하면서 비교
            while(arr[pr]>pivot) pr--; // 오른쪽에서 피벗방향으로 인덱스를 감소하면서 비교

            System.out.println("pl : "+pl + "    "+"pr : "+pr);

            if(pl<=pr){ //do while이라 무조건 실행이 되니 한 번 조건에 부합하는지 검사를 한다.
                swap(arr,pl++,pr--);
            }
        }while(pl<=pr); // 이때까지는 계속 돌릴 것

        if(left<pr) quickSort(arr,left,pr);
        if(right>pl) quickSort(arr, pl,right);
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
