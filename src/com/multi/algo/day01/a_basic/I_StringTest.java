package com.multi.algo.day01.a_basic;


public class I_StringTest {
    public static void main(String[] args) {
        String s = "[ 10, 20, 30, 40, 50 ]";

        // [ ] 제거

        s= s.replace("[","");
        s= s.replace("]","");

        s = s.trim();

        String[] sSplit = s.split(", ");
        System.out.println(sSplit[3]);

        // 배열의 합을 구해라

        int result = 0;
        for(String sElement : sSplit){
            result += Integer.valueOf(sElement);
        }
        System.out.println(result);



    }
}
