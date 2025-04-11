package com.multi.algo.day05.etc;


import java.util.Arrays;

public class G_KthNumber {
    public static void main(String[] args) {
        int[] num = { 3, 4, 5, 1, 2, 8, 7, 6 };
        int k = 3;

        Arrays.sort(num);

        System.out.println(num[num.length-1]);
        System.out.println(num[num.length-2]);

        System.out.println(num[num.length-k]);


    }
}
