package com.multi.algo.day01.a_basic;


import java.util.Arrays;
import java.util.Random;

public class H_DiffArray {
    public static void main(String[] args) {
        Random r = new Random();

        int[] num1 = new int[1000];
        int[] num2 = new int[1000];

        for (int i = 0; i < num1.length; i++) {
            num1[i] = r.nextInt(1000); //0-999
            num2[i] = r.nextInt(1000); //0-999
//            num2[i] = num1[i]; //0-999
        }

        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));

        System.out.println(num1 == num2); //주소 비교
        System.out.println(Arrays.equals(num1,num2)); //값비교

        int[] num3 = {1,2};
        int[] num4 = {1,2};

        System.out.println(Arrays.equals(num3,num4));

        int[] num5 = num4.clone();
        System.out.println(num5==num4);
        System.out.println(Arrays.equals(num4, num5));
    }
}
