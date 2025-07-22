package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_10815 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            set.add(Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(m>0){
            int num = Integer.parseInt(st.nextToken());

            if(set.contains(num))
                bw.write("1 ");
            else
                bw.write("0 ");
            m--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
