package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // a의 원소를 set에 담는다

        // b의 원소가 set에 포함되면 set에서 제거
        // b의 원소가 set에 포함 안되면 set에 추가

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        while(a>0){
            set.add(Integer.parseInt(st.nextToken()));

            a--;
        }

        st = new StringTokenizer(br.readLine());
        while(b>0){
            int num = Integer.parseInt(st.nextToken());

            if(set.contains(num))
                set.remove(num);
            else
                set.add(num);

            b--;
        }

        bw.write(set.size()+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
