package com.multi.algo.day03;


public class D_StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("honghong");
        System.out.println(sb1);

        StringBuilder sb11 = new StringBuilder("honghong");
        System.out.println(sb11);

        StringBuilder sb2 = new StringBuilder("honghong");
        System.out.println(sb2);

        System.out.println(sb1 == sb2);
        sb1.append("hahaha");
        System.out.println(sb1);
        sb1.replace(0, 8, "hohohoh");
        System.out.println(sb1);
        sb1.delete(0, 8);
        System.out.println(sb1);
        sb1.deleteCharAt(0);
        System.out.println(sb1);
        sb1.reverse();
        System.out.println(sb1);

        StringBuilder sb = new StringBuilder();
        sb.append("오늘 월요일이야");
        sb.insert(2, " 진짜" );
        System.out.println(sb.length());
        System.out.println(sb);
        sb.replace(0, 2, "내일");
        System.out.println(sb);
        sb.delete(0, 2);
        System.out.println(sb);
        sb.setCharAt(0, '와');
        System.out.println(sb);
        sb.insert(1, " " );
        System.out.println(sb);
        String sub = sb.substring(5);
        System.out.println(sub);
        StringBuilder rev = sb.reverse();
        System.out.println(rev);


        String result = sb.toString();
        System.out.println(result);


    }
}
