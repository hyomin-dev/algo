package com.multi.baekjoon._1DArray;


import java.io.*;
import java.util.StringTokenizer;

public class P_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numArray = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String num = br.readLine();
        int count = 0;

        while(st.hasMoreTokens()){
            if(st.nextToken().equals(num))
                count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();


    }
}
