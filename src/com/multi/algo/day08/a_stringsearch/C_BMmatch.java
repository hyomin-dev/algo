package com.multi.algo.day08.a_stringsearch;


import java.util.Arrays;

public class C_BMmatch {
    // 보이어-무어법으로 문자열 검색


    //보이어-무어 알고리즘의 작동은 KMP 알고리즘과 유사하게 불필요한 비교는 건너뛰고 유의미한 비교만 진행하겠다는 것
    //KMP 알고리즘의 경우에는 접두사와 접미사가 같은 최대길이를 저장하는 배열을 만들어 앞에서부터 검사를 진행하였다면,
    //보이어-무어 알고리즘은 문자열을 검색할때 주로 뒤에서 부터 확인

        //
    //나쁜문자이동(bad character) - 문자열과 패턴이 불일치 하도록 패턴이동
    //                    - 나쁜 문자가 패턴 내에 존재하지 않으면, 패턴 전체 길이만큼 점프
    //                    - 나쁜 문자가 패턴 내에 존재하면, 패턴 내에서 그 문자와 가장 마지막으로 일치하는 위치까지 점프


    //  0  'a'    6 - 0 - 1 = 5  skip['a'] = 5
    //  1  'b'    6 - 1 - 1 = 4  skip['b'] = 4
    //  2  'c'    6 - 2 - 1 = 3  skip['c'] = 3
    //  3  'a'    6 - 3 - 1 = 2  skip['a'] = 2 (덮어씀)
    //  4  'b'    6 - 4 - 1 = 1  skip['b'] = 1 (덮어씀)
    public static void main(String[] args) {
        String s1 = "i am a student.";
        String s2 = "student";

//        String s1 ="babcabcd";
//        String s2= "abcabc";

        int idx = bmMatch(s1, s2);
        if (idx == -1) {
            System.out.println("텍스트 안에 패턴이 없습니다.");
        } else {
            int len = s1.substring(0, idx).length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트: " + s1);
            System.out.printf(String.format("패  턴: %%%ds\n", len), s2);
        }
    }

    private static int bmMatch(String txt, String pat) {

        int pt = 0;
        int pp = 0;

        int textlen = txt.length();
        int patLen = pat.length();

        int[] skip = new int[Character.MAX_VALUE + 1];

        for (pt = 0; pt <= Character.MAX_VALUE; pt++)
            skip[pt] = patLen; // 기본값은 패턴 전체 길이로 초기화

        for (pt = 0; pt < patLen - 1; pt++){
            System.out.println("patLen - pt -1 : "+pat.charAt(pt)+ "     "+(patLen-pt-1));
            skip[pat.charAt(pt)] = patLen - pt - 1;
        }


        System.out.println(Arrays.toString(skip));

        while(pt < txt.length()){
            pp = patLen -1 ;
            while(txt.charAt(pt)==pat.charAt(pp)){

                if(pp==0){
                    return pt;
                }
                pp--;
                pt--;
            }

            // --- 일치 실패 시, 점프할 거리 계산 --- //
            // 현재 본문 문자에 대응하는 skip 거리와, 비교에 실패한 위치(pp)에 따라 더 긴 쪽으로 점프
            int chk = skip[txt.charAt(pt)];
            System.out.println("불일치 문자 skip: "+ chk);
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp; //pt 가 첨에 6 이었는데 7 더해지면 13됨
            System.out.println(pt);
        }

        return -1;

    }
}
