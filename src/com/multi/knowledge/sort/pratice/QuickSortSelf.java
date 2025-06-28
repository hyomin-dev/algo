package com.multi.knowledge.sort.pratice;


import java.util.Arrays;

public class QuickSortSelf {
    public static void main(String[] args) {
        int n= 10;
        //int[] arr = {0, 1, 2, 3, 4, 5, 6,7,8, 9};
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, 10-1);

        System.out.println("========================================");

        System.out.println(Arrays.toString(arr));



    }

    static void quickSort(int[] arr, int start, int end){

        if(start>=end)
            return; // 원소가 1개인 경우 stop
        int pivot = start;
        int left = start+1;
        int right = end;

        while(left<=right){

            //left 이동
            // arr[pivot]보다 큰 것을 발견하기 전까지 오른쪽으로 이동
            while(left<=end&&arr[left]<=arr[pivot])
                left++;

            //right 이동
            //arr[pivot]보다 작은 것을 발견하기 전까지 왼쪽으로 이동
            while(right>start && arr[right]>=arr[pivot])
                right--;

            if(left>right){
                int tmp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = tmp;

            }else{
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }

        quickSort(arr,start, right-1);
        quickSort(arr,right+1,end);


    }
}
