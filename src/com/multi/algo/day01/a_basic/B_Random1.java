package com.multi.algo.day01.a_basic;


import java.util.Arrays;
import java.util.Random;

public class B_Random1 {
    public static void main(String[] args) {
        Random r = new Random();

        int[] num = new int[1000];

        for(int i=0;i<num.length; i++){
            num[i] = r.nextInt(101);
        }
        System.out.println(Arrays.toString(num));

        for(int k:num) {
            System.out.print(k);
            System.out.print(", ");
        }



    }
}
