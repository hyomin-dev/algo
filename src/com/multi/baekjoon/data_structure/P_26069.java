package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        int count = 1;

        while(n>0){

            StringTokenizer st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();

            // 둘다 없으면 패스
            // 한 사람이라도 있는 경우

            if(set.contains(a)&&!set.contains(b)){
                // a는 춤을 추는데, b는 춤을 안추는 경우
                set.add(b);
                count++;
            }else if(set.contains(b)&&!set.contains(a)){
                // b는 춤을 추는데, a는 춤을 안추는 경우
                set.add(a);
                count++;
            }

            n--;
        }

        bw.write(count+"");
        bw.close();
        br.close();

    }
}
