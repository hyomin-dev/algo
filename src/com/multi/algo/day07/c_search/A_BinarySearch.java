package com.multi.algo.day07.c_search;


import java.util.Arrays;

public class A_BinarySearch {
    public static void main(String[] args) {

        int[] num = { 1, 4, 5, 2, 7, 8, 9, 6 };
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
        System.out.println(Arrays.binarySearch(num, 5));
        System.out.println(Arrays.binarySearch(num, 10));
        //-이면 존재하지 않는다는 의미
        System.out.println(Arrays.binarySearch(num, 1, 5, 2)); // 부분배열사용(인덱스 1부터 5까지)
        System.out.println(Arrays.binarySearch(num, 1, 5, 8));

    }
}
