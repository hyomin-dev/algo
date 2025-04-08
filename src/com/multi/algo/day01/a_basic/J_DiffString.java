package com.multi.algo.day01.a_basic;


public class J_DiffString {
    public static void main(String[] args) {
        String s = "정길동";
        String s2 = "정길동";

        //주소 비교
        System.out.println("s == s2 = "+(s==s2));

        //값 비교
        System.out.println("s.equals(s2) = "+(s.equals(s2)));

        s = "김길동";
        //주소비교
        System.out.println("s == s2 = "+(s==s2));

        //값 비교
        System.out.println("s.equals(s2) = "+(s.equals(s2)));

        StringBuilder builder = new StringBuilder();

        builder.append("송길동");

        System.out.println(builder);


    }
}
