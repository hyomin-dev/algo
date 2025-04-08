package com.multi.algo.day01.b_prac;


import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("ppt 60 problem 3 =======================================================");
        // ppt 60 problem 3

        String s1 = "참좋다";
        String s2 = "진짜좋다";

        System.out.println("s1 == s2 = "+s1.equals(s2));
        System.out.println("s1 length == s2 length = "+(s1.length()==s2.length()));

        System.out.println("ppt 60 problem 4 =======================================================");
        // ppt 60 problem 4

        String s3 = "나는 진짜 java programmer가 되었어";
        String sub = "java programmer";
        int idx = s3.indexOf(sub);

        System.out.println(s3.substring(idx,idx+sub.length()).toUpperCase());

        System.out.println("ppt 60 problem 5 =======================================================");
        // ppt 60 problem 5

        String s4 = "2056521";
        System.out.println();
        if(s4.substring(0,1).equals("2"))
            System.out.println("여자");
        else
            System.out.println("남자");

        System.out.println("ppt 79 problem =======================================================");

        // ppt 79 problem 1
        String tel = sc.nextLine();

        //ppt 79 problem2
        tel = tel.trim();
        String[] telArr = tel.split("-");

        //ppt 79 problem3
        if(telArr[0].equals("011"))
            System.out.println("SK");
        else if(telArr[0].equals("019"))
            System.out.println("LG");
        else
            System.out.println("Apple");

        //ppt 79 problem4
        if(telArr[1].length()>=4)
            System.out.println("최신폰");
        else
            System.out.println("올드폰");

        //ppt 79 problem5
        if((telArr[0].length()+telArr[1].length()+telArr[2].length())>=10)
            System.out.println("유효한 전화번호");
        else
            System.out.println("유효하지 않은 전화번호");

        System.out.println("ppt 80 problem 1 =======================================================");

        String s = "  '휴지', '블루볼펜', '지우개'+=-";

        // ppt 80 problem 1
        s = s.trim();
        s= s.replace("'","");
        s = s.replace(" ","");
        s = s.replace("+","");
        s = s.replace("=","");
        s = s.replace("-","");

        String[] sArr = s.split(",");


        // ppt 80 problem2
        if(sArr[1].contains("블루"))
            System.out.println("파란볼펜이군요!");
        else
            System.out.println("빨간볼펜이군요!");

        // ppt 80 problem3

        int minIdx = 0;
        for(int i=1;i<sArr.length;i++)
            if(sArr[i].length()<sArr[minIdx].length())
                minIdx = i;
        System.out.println("가장 짧은 문자열은: "+sArr[minIdx]);

        // ppt 80 problem4
        int[] arr = new int[3];
        for(int i=0;i<arr.length;i++)
            arr[i] = sArr[i].length();

        int sum=0;
        for(int n: arr)
            sum +=n;
        System.out.println("문자열의 합은: "+sum);




    }
}
