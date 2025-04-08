package com.multi.algo.day01.a_basic;


import java.util.Arrays;
import java.util.Random;

public class C_Random {
    public static void main(String[] args) {
        double[] num = {11.1, 22.2, 33.3, 22.2, 55.5};
        System.out.println(Arrays.toString(num));

        for(int i=0; i<num.length;i++) {
            if (num[i]==33.3)
                System.out.println("33.3 index: "+i);
            else if(num[i]==22.2)
                System.out.println("22.2 index: "+i);
        }



        int count = 0;
        for(int i=0; i<num.length;i++) {
            if (num[i]==22.2)
                count++;
        }

        System.out.println("count : "+count);

    }
}
