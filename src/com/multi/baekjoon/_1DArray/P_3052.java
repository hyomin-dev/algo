package com.multi.baekjoon._1DArray;


import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class P_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new HashSet<>();

        int count=0;
        while(count<10){
            Integer num = Integer.parseInt(br.readLine());
            set.add(num%42);
            count++;

        }

        bw.write(set.size()+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
