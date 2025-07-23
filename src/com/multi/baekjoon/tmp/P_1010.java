package com.multi.baekjoon.tmp;

import java.io.*;
import java.util.*;

public class P_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long up = 1;
            long down;

            int sub = m-n;

            if(n<sub){
                for(int i=0;i<n;i++) {
                    up = up *m;
                    m--;
                }
                down = factorial(n);
            }else{
                for(int i=0;i<sub;i++) {
                    up = up *m;
                    m--;
                }
                down = factorial(sub);
            }

           bw.write(up/down+"\n");
            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static long factorial(long n){
        if(n<=1)
            return 1;
        return n*factorial(n-1);
    }
}
