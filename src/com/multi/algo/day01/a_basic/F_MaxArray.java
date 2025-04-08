package com.multi.algo.day01.a_basic;


import java.util.Random;

public class F_MaxArray {
    public static void main(String[] args) {

        // 랜덤한 값 1000개를 발생시켜 배열에 넣어
        // 1. 최대값을 구해보세요.
        // 2. 최대값의 개수는??

        Random r = new Random(System.currentTimeMillis());
        int[] arrays = new int[1000];

        int maxIdx =0;
        int count = 0;

        for(int i=0;i<arrays.length;i++){
            arrays[i] = r.nextInt(999)+1;
            if(i==0)
                continue;
            if(arrays[i]>arrays[maxIdx]){
                count=0;
                count++;
            }
        }

        maxIdx =0;
        for(int i=1;i<arrays.length;i++){
            if(arrays[i]>arrays[maxIdx]){
                maxIdx = i;
            }
        }

//        for(int i=0;i<arrays.length;i++){
//            if(arrays[i]==arrays[maxIdx]){
//                count++;
//            }
//        }

        System.out.println("최대 값은: "+arrays[maxIdx]);
        System.out.println("최대 값의 개수는: "+count);

    }
}
