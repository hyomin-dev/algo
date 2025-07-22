package com.multi.baekjoon.tmp;

import java.io.*;
import java.util.*;

public class P_28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        int num = 0;
        if(s1.charAt(0)!='F'&&s1.charAt(0)!='B'){ // s1이 숫자인 경우

            num = Integer.parseInt(s1)+3;
        }else if(s2.charAt(0)!='F'&&s2.charAt(0)!='B'){ // s2가 숫자 인경우
            num = Integer.parseInt(s2)+2;
        }else{ //s3가 숫자 인 경우
            num = Integer.parseInt(s3)+1;
        }

        if(num%3==0&&num%5==0)
            bw.write("FizzBuzz");
        else if(num%3==0)
            bw.write("Fizz");
        else if(num%5==0)
            bw.write("Buzz");
        else
            bw.write(num+"");

        bw.flush();
        bw.close();
        br.close();

    }
}

/*
3과 5의 배수 --> FizzBuzz

3의 배수, 5의 배수 아닌 경우 --> Fizz

3의 배수 아니고, 5의 배수 --> Buzz

FizzBuzz와 Fizz, Buzz는 한 번에 나올 수 없다. --> 3개 중에 하나는 숫자

* */
