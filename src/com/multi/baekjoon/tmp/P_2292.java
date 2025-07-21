package com.multi.baekjoon.tmp;

import java.io.*;
import java.util.*;

public class P_2292 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int l=1;
        int end = 1+6*(l-1);
        int start = 1;
        while(true){

            if(start<=n&&n<=end){
                break;
            }
            start = end+1;
            l++;
            end = end+6*(l-1);

        }

        bw.write(l+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
