package com.multi.algo.day07.baekjoon;


import java.util.Arrays;
import java.util.Scanner;

public class P_1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();

        int[] numArr1 = new int[num1];
        for(int i=0;i<num1;i++)
            numArr1[i] = sc.nextInt();

        int num2 = sc.nextInt();

        int[] numArr2 = new int[num2];
        for(int i=0;i<num2;i++)
            numArr2[i] = sc.nextInt();

        Arrays.sort(numArr1);
        for(int n: numArr2){
            if(binarySearch(numArr1,n)<0)
                System.out.println(0);
            else
                System.out.println(1);
        }

        System.out.println(Arrays.toString(numArr1));
    }

    public static int binarySearch(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            // key값이 중간 위치의 값보다 작을 경우
            if (key < arr[mid]) {
                hi = mid - 1;
            } else if (key > arr[mid]) { // key값이 중간 위치의 값보다 클 경우
                lo = mid + 1;
            } else { // key값과 중간 위치의 값이 같을 경우
                return mid; // 검색 성공
            }
        }
        // 찾고자 하는 값이 존재하지 않을 경우
        return -1;
    }
}
