package com.multi.algo.day03;


import java.util.*;
import java.util.stream.Collectors;

public class B_ArrayCollection {
    public static void main(String[] args) {
        String[] s3 = { "박명수", "유재석", "ㄴㄴ", "김종국", "송지효", "하하" };
        System.out.println("리스트로 변경============================================");
        //리스트로 변경
        List<String> list = new ArrayList<>(Arrays.asList(s3));
        System.out.println(list);

        System.out.println("오름 차순 정렬============================================");
        //오름 차순 정렬
        Collections.sort(list);
        System.out.println(list);

        System.out.println("내림차순============================================");
        //내림차순
        Collections.reverse(list);
        System.out.println(list);

        System.out.println("글자수가 3 미만인 경우 삭제 후 출력 ============================================");
        //글자수가 3 미만인 경우 삭제 후 출력
        list = list.stream().filter(s->s.length()>=3).collect(Collectors.toList());
        System.out.println(list);

       /* String find = "";
        for(String x:list){
            if(x.length()<3){
                find = x;
            }
        }
        list.remove(find);
        System.out.println(list);*/

       /* Iterator<String> it = list.iterator();
        while(it.hasNext()){
            if(it.next().length()<3)
                it.remove();
        }
        System.out.println(list);*/




        System.out.println("박명수 추가============================================");
        //박명수 추가
        list.add("박명수");
        System.out.println(list);

        System.out.println("박명수가 있는 위치 출력============================================");
        //박명수가 있는 위치 출력
        System.out.println(list.lastIndexOf("박명수"));


        //출력 예시 3가지 방법으로 해보기(반환형 -> 출력예)

        System.out.println("String 출력============================================");
        //1. String
        String result = "";
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals("박명수")){
                result += i+" ";
            }
        }

//        list.stream().forEach(s->System.out.printf("%s ",s));
        System.out.println(result);

        System.out.println("컬렉션 출력============================================");
        //2.컬렉션
        ArrayList<Integer> result2 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals("박명수"))
                result2.add(i);
        }

        System.out.println(result2);

        System.out.println("배열 출력============================================");
        //3. 배열
        int[] result3 = new int[result2.size()];
        for(int i=0;i<result2.size();i++)
            result3[i] = result2.get(i);

        System.out.println(Arrays.toString(result3));

        System.out.println("유재석을 찾아서 유재석 2로 변경한 후 출력============================================");
        // 유재석을 찾아서 유재석2로 변경한 후 프린트
        list.set(list.indexOf("유재석"),"유재석2");
        System.out.println(list);


        System.out.println("전체 목록에 김종민을 3번째에 삽입한 후 프린트============================================");
        //전체 목록에 "김종민"을 3번째에 삽입한 후 프린트
        list.add(2,"김종민");
        System.out.println(list);


        System.out.println("문자열에서 숫자가 있는 위치 출력============================================");

        // 숫자가 있는 위치( 몇번째)
        int num = 29183;
        int find =1;

        // 방법 1 -> String.valueOf()
        // 방법 2 -> int값 + "";

        String str = num+"";
        String findStr = find+"";

        int answer = -1;
        if(str.contains(findStr))
            answer = str.indexOf(findStr)+1;
        System.out.println(answer);







    }
}
