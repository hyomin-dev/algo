package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.StringTokenizer;

public class P_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int eYear = Integer.parseInt(st.nextToken());
        int sYear = Integer.parseInt(st.nextToken());
        int mYear = Integer.parseInt(st.nextToken());

        int eCount = 1;
        int sCount = 1;
        int mCount = 1;
        int year = 1;

        while(true){

            if(eCount==eYear && sCount == sYear && mCount==mYear)
                break;

            year++;
            if(eCount>=15)
                eCount = 1;
            else
                eCount++;

            if(sCount>=28)
                sCount = 1;
            else
                sCount++;

            if(mCount>=19)
                mCount = 1;
            else
                mCount++;
        }

        bw.write(String.valueOf(year));
        bw.flush();
        bw.close();
        br.close();

    }
}
