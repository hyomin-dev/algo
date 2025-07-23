package com.multi.baekjoon.simulation;

import java.io.*;
import java.util.*;

public class P_25501 {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){

            String s = br.readLine();

            count = 0;
            int result = isPalindrome(s);
            bw.write(result+" "+count+"\n");
            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}
