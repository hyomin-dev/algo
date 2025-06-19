package com.multi.algo.day08.a_stringsearch;


public class A_BFmath {

    // 브루트-포스법에 의한 문자열 검색

    //Brute : 무식한
    //
    //Force : 힘
    //
    //
    //
    //직역하면, 무식한 힘을 갖는 알고리즘이란 뜻으로, 완전 탐색 알고리즘의 한 종류이지만 완전 탐색의 또 다른 이름으로 쓰이기도 한다.
    // 브루트 포스 알고리즘은 완전탐색으로 답을 도출하는 알고리즘이며, 대부분은 반복문과 조건문을 통하여 답을 도출한다.


    //i am a student
    //student  첫 인덱스 비교  같지않다
    //
    //
    //i am a student
    // student 두번째 인덱스 비교  같지않다
    //        ...  이렇게 쭉 비교 하다가
    //
    //i am a student
    //       student 7번째 인덱스 비교  같다
    //
    // 그럼 이때 부터는
    //i am a student
    //       |||||||
    //       student 이렇게 비교한다

    public static void main(String[] args) {
        String s1 = "i am a student.";
        String s2 = "studentgg";

        int idx = bfMatch(s1, s2);

        if (idx == -1)
            System.out.println("텍스트 안에 패턴이 없습니다.");
        else {
            int len = s1.substring(0, idx).length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트: " + s1);
            System.out.printf(String.format("패  턴: %%%ds\n", len), s2);
        }
    }

    private static int bfMatch(String txt, String pat) {

        int pt = 0; // txt에 사용하는 커서
        int pp =0; // pattern에 사용하는 커서

        while(pt!=txt.length()&& pp!=pat.length()) //둘다 비교를 해야한다.
        {
            if(txt.charAt(pt)==pat.charAt(pp)){
                pt++;
                pp++;
            }else{
                pt = pt-pp+1; // 같이 증가하고있으니 증가한만큼 빼주고, 다음 커서로 넘어간다.
                pp = 0; // pattern은 처음부터 검색할 수 있도록

            }

            if(pp == pat.length())
                return pt-pp;

        }

        return -1;
    }
}
