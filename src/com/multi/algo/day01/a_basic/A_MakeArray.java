package com.multi.algo.day01.a_basic;


import java.util.Arrays;

public class A_MakeArray {

    public static void main(String[] args) {
        //1. 이미 값을 알고 있는 경우
        int[] ages = {10,20,30,40};

        // 1. for
        for(int i=0;i< ages.length;i++)
            System.out.println(ages[i]);

        // 2. foreach
        for(int n: ages)
            System.out.println(n);

        // 3. Arrays.toString
        System.out.println(Arrays.toString(ages));

        //4. 스트림
        System.out.println("A_MakeArray.main");
        Arrays.stream(ages).forEach(System.out::println);




        //2. 값을 모르는 경우
        int[] age2 = new int[5];
        age2[0] = 55;




    }
}
