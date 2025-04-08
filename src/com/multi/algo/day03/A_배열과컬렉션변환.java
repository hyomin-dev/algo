package c_etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A_배열과컬렉션변환 {

    public static void main(String[] args) {
        int[] s = { 5, 2, 1, 9, 11, 15, 17 };


        System.out.println(Arrays.toString(s));

        Arrays.sort(s);

        System.out.println(Arrays.toString(s));


        String[] s2 = {"aaa", "bbb", "ccc", "aaa"};

        //방법1 배열 -> list
        List<String> list = Arrays.asList(s2);
        System.out.println(list);

        //list.remove(1);
        //list.add("ddd");
        //add/remove되지 않는 제약이 있음.  // 배열을 리스트 처럼 다루긴하지만 ,내부적으로는 배열을 가리키고있다 //size 조정하는 것은 불가능

        System.out.println(list.contains("aaa"));
        System.out.println(list.indexOf("aaa"));
        System.out.println(list.lastIndexOf("aaa"));

        list.set(2,"ddd");
        System.out.println(list);

        //방법2 배열 -> list
        List<String> list2 = new ArrayList<>(Arrays.asList(s2));

        list2.add("eee");
        list2.remove("bbb");
        System.out.println(list2);

        //방법3 배열 -> list
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        for (int x : s) {
            list3.add(x);
        }


        // 컬렉션즈 정렬
        System.out.println(list3);
        Collections.reverse(list3);
        System.out.println(list3);
        Collections.sort(list3);
        System.out.println(list3);


        System.out.println("----------------");


        //방법1 리스트 -> 배열
        String[] s3 = list.toArray(new String[0]);
        System.out.println(Arrays.toString(s3));


        //방법2 리스트 -> 배열
        String[] s4 = new String[list.size()];
        for(int i =0; i <s4.length ;i++){
            s4[i] = list.get(i);
        }

        System.out.println(Arrays.toString(s4));

    }
}
