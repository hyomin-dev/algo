package com.multi.algo.day08.a_stringsearch;


import java.util.Arrays;

public class B_KMP {

    // KMP법에 의한 문자열 검색


    //KMP 알고리즘이란, 문자열 탐색 알고리즘으로써 알고리즘을 만든 사람들(Knuth-Morris-Pratt)의 앞글자를 딴 것이다.

    //
    //KMP 알고리즘의 전체 시간 복잡도는 O(N + M) 이다.
    //N: 텍스트의 길이
    //M: 패턴의 길이
    //
    //KMP 알고리즘은 접두사(prefix)와 접미사(suffix)의 개념을 활용하여 실패함수 테이블을 만들고,
    // 테이블을 활용하여 반복되는 문자열을 건너뛰면서 패턴을 찾는 알고리즘이다.
    //
    //
    //pi 테이블은 패턴의 각 접미사 위치까지의 접두사-접미사 중 일치하는 최대 길이를 저장

    //i am a student  에서 student 를 찾을때  브루트-포스법 를 사용하면 o (n*m) 으로 모든 경우를 보니까 비효율적
    //student


        //패턴: s t u d e n t
    //Pi 테이블 초기화: [0, 0, 0, 0, 0, 0, 0] //접두사와 접미사가 일치하는 최대 길이를 저장  (인덱스 s 와 비교 해서 모두0)
    // 패턴만 가지고 pi 테이블 먼저 생성
    //
    //"패턴 안에서 앞뒤가 얼마나 닮았는지(접두사 = 접미사)" 분석
    //
    //예: abcabc → pi = [0, 0, 0, 1, 2, 3]

    //babcabcd
    //abcabb
    // pi = [0, 0, 0, 1, 2, 0]

    //babcabcd
    //abcabb

    //babcabcd
    // abcabb

    // babcabcd
    // |||||x
    // abcabb

    // 불일치 시점의 pp 기준으로 pi[pp - 1]를 확인
    //
    // 그만큼 이미 맞았던 접두사-접미사가 있으니 거기까지 점프
    //
    // pi[pp - 1] == 0이면 그냥 패턴 처음부터 비교

    //babcabcd
    //      |
    //    abcabb     c  와 c 일치  , 앞에꺼는 비교 안함

    //babcabcd
    //       /
    //    abcabb     그다음 d  와 a 불일치  a 의 바로 앞 c 인덱스킄 0  그래서 다음은 다시 처음 부터 비교

    //babcabcd

    //    abcabb     불일치

    public static void main(String[] args) {
//        String s1 ="babcabcd";
//        String s2= "abcabc";
        String s1 = "i am a student.";
        String s2 = "student";

        int idx = kmpMatch(s1, s2);
        if (idx == -1)
            System.out.println("텍스트 안에 패턴이 없습니다.");
        else {
            int len = s1.substring(0, idx).length();


            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트: " + s1);
            System.out.printf(String.format("패  턴: %%%ds\n", len), s2);
        }

    }

    private static int kmpMatch(String txt, String pat) {

        int pt = 1; // 1부터 시작...
        int pp = 0;

        int[] skip = new int[pat.length()];

        skip[0] = 0; //pattern table에서 첫 문자는 담지 않는다.
        while(pt!=pat.length()){ //pattern table을 만든 것

            // 첫 문자를 비교한다.
            if (pat.charAt(pt) == pat.charAt(pp))  // 현재 문자들이 일치하면
                skip[pt++] = ++pp;
            else if (pp == 0)    // 일치하지 않고 pp가 0이면
                skip[pt++] = pp;
            else   // 일치하지 않고 pp가 0이 아니면 계속 줄여서 일치하는 패턴이 있는지 확인
                pp = skip[pp - 1];
        }

        System.out.println(Arrays.toString(skip));

        pt = pp = 0; // 이제 찾은 pattern을 가지고 검색해야하기 때문에 초기화

        while (pt != txt.length() && pp != pat.length()) {
            if(txt.charAt(pt) == pat.charAt(pp)){
                pt++;
                pp++;
            }else if(pp ==0){
                pt++;
            }else{
                pp = skip[pp-1];
            }
        }

        if(pp == pat.length()) {
            return pt - pp;
        }

        return -1;
    }
}
