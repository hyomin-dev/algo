package com.multi.algo.day02.b_programmers;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
       solution("allpe","apple");

    }


    public static int solution(String before, String after) {

        int length = before.length();

        char[] beforeArr = new char[length];

        //size 5
        // 0 1 2 3 4
        // 4 3 2 1 0
        for(int i=length-1;i>=0;i--)
            beforeArr[length-1-i] =before.charAt(i);

        String beforeReverse = new String(beforeArr);

        if(beforeReverse.equals(after))
            return 1;
        else
            return 0;


    }
}
