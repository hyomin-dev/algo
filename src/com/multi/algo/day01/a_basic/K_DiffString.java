package com.multi.algo.day01.a_basic;


public class K_DiffString {
    public static void main(String[] args) {

        String all = "국어, 영어, 수학, 컴퓨터";

        //1.
        String[] allArrays = all.split(", ");

        //3.
        System.out.println("과목 수는? : "+allArrays.length);

        //4.
        for(int i=0;i<allArrays.length;i++){
            if(allArrays[i].equals("컴퓨터")){
                System.out.println("컴퓨터의 위치는: "+i);
                break;
            }
        }

        //5.
        int count = 0;
        for(int i=0; i<allArrays.length;i++)
            if(allArrays[i].length()<3)
                count++;

        System.out.println("과목명이 3글자 미만인 과목수는?: "+count);

    }
}
