package com.multi.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class P_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int q = 25; // 쿼터
        int d = 10; // 다임
        int n = 5; // 니켈
        int p = 1; // 페니

        while(t>0){

            int change = Integer.parseInt(br.readLine());

            int qNum = 0;
            int dNum = 0;
            int nNum = 0;
            int pNum = 0;

            if(change>=q){
                qNum = change/q;
                change = change%q;
            }

            if(change>=d){
                dNum = change/d;
                change = change%d;
            }

            if(change>=n){
                nNum = change/n;
                change = change%n;
            }

            if(change>=p){
                pNum = change/p;
            }

            bw.write(qNum +" "+dNum+" "+nNum+" "+pNum+"\n");

            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
