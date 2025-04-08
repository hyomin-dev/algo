package com.multi.algo.day03;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class E_StringToChar {
    public static void main(String[] args) {
        String sno = "2056521";
        //1. 마지막 위치의 숫자가 1이면 서대문구에서 출생,
        //   1이 아니면 다른 구에서 출생 출력

        if(sno.charAt(sno.length()-1)=='1')
            System.out.println("서대문구에서 출생");
        else
            System.out.println("다른 구에서 출생");

         /*
        char[] two = new char[2];
        sno.getChars(4, 6, two, 0);
        System.out.println(Arrays.toString(two));

        int i1 = Character.getNumericValue(two[0]);
        int i2 = Character.getNumericValue(two[1]);
        int sum = i1 + i2;
        System.out.println(sum);
        if(sum < 10) {
            System.out.println("유효한 주민번호O");
        }else {
            System.out.println("유효한 주민번호X");
        }
        int  i1 = Character.getNumericValue(two);
        * */


        //2. "52"를 추출하여 두 숫자를 더해보세요.
        //   더해서 10이 넘지않아야 유효한 주민번호
        //   유효한 주민번호인지 아닌지 출력



        int idx = sno.indexOf("52");
        String str1 = sno.substring(idx,idx+2);
        //System.out.println(str1);
        int num1 = Integer.parseInt(str1.charAt(0)+"");
        int num2 = Integer.parseInt(str1.charAt(1)+"");
        if(num1+num2<10)
            System.out.println("유효한 주민번호");
        else
            System.out.println("유효하지 않은 주민번호");



        //3. 주민번호에 포함된 5의 갯수를 출력
        //String안에 들어있는 데이터를 각각 분리를 해주어야 한다.
        //분리하는 방법??

        //1)String배열-split()
        String[] snoArr = sno.split("");
        int count1 = 0;
        for(String s: snoArr)
            if(s.equals("5"))
                count1++;

        System.out.println(count1);

        //2)charAt(i)
        int count2=0;
        for(int i =0;i<sno.length();i++){
            if(sno.charAt(i)=='5')
                count2++;
        }

        System.out.println(count2);

        // (3) 인덱스를 빨리 찾는 방법(함수)

        System.out.println(Arrays.binarySearch(snoArr,"2"));

        //배열에 특정한 값을 한꺼번에 변경할 수 있는 함수("hoho")
        Arrays.fill(snoArr, 0, 3, "hoho");
        System.out.println(Arrays.toString(snoArr));

        //배열안에 데이터 ("hoho")의 빈도수(횟수)구하는 방법(함수) -컬렉션 변경 후 함수
        List<String> list = Arrays.asList(snoArr);
        int count4 = Collections.frequency(list,"hoho");
        System.out.println(count4);



    }
}
