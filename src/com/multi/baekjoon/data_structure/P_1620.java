package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_1620 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        String[] array = new String[n+1];

        for(int i=1;i<=n;i++){
            String str = br.readLine();
            map.put(str,i);
            array[i] = str;
        }

        for(int i=0;i<m;i++){
            String s = br.readLine();

            if('9'<s.charAt(0)){ // 문자 인 경우
                bw.write(map.get(s)+"\n");
            }else
                bw.write(array[Integer.parseInt(s)]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
