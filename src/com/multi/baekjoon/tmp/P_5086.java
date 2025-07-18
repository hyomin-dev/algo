package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.StringTokenizer;

public class P_5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());

            if(n1==0)
                break;
            int n2 = Integer.parseInt(st.nextToken());

            if(n1<n2&&n2%n1==0)
                bw.write("factor\n");
            else if(n1>n2&&n1%n2==0)
                bw.write("multiple\n");
            else
                bw.write("neither\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
