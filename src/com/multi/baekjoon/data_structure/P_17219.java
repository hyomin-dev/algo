package com.multi.baekjoon.data_structure;


import java.io.*;
import java.util.*;

public class P_17219 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        while(n>0){
            st = new StringTokenizer(br.readLine());

            String key = st.nextToken();
            String value = st.nextToken();

            map.put(key,value);
            n--;
        }

        while(m>0){

            bw.write(map.get(br.readLine())+"\n");
            m--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
