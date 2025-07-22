package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int count = 0;

        while(n>0){

            String input = br.readLine();

            if(input.equals("ENTER")){
                count +=set.size();
                set = new HashSet<>();
            }else{
                set.add(input);
            }

            if(n==1)
                count +=set.size();
            n--;
        }

        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();

    }
}
