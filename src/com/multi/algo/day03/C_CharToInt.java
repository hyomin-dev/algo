package com.multi.algo.day03;


public class C_CharToInt {
    public static void main(String[] args) {

        // 1. char ==> int 로 변경하는 방법
        char c = '0'-'0';
        System.out.println(c+1);

        c = '1' - '0';
        System.out.println(c+0);

        // '0' --> 48, '1' --> 49

        System.out.println('5'-'0');

        // 2. char => int로 변경하는 방법 2
        c = '1';
        int i = Integer.parseInt(c+"");
        System.out.println(i);

        // 3. 숫자를 문자로 변환
        System.out.println((char)(-5-3+'0'));


    }
}
