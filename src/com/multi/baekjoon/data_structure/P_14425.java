package com.multi.baekjoon.data_structure;


import java.io.*;
import java.util.*;

public class P_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++)
            set.add(br.readLine());

        int count = 0;
        while(m>0){
            String str = br.readLine();

            if(set.contains(str))
                count++;

            m--;
        }

        bw.write(count+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
