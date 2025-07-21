package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.*;

public class P_11050 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int up = 1;
        for(int i=n;i>n-k;i--){
            up *=i;
        }

        int down = 1;
        for(int i=1;i<=k;i++){
            down *=i;
        }
        bw.write(up/down+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
