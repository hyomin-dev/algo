package com.multi.baekjoon.charandstring;


import java.io.*;
import java.util.StringTokenizer;

public class P_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        String num1Str = st.nextToken();
        String num2Str = st.nextToken();

        String reverseNum1Str = String.valueOf(num1Str.charAt(2))+String.valueOf(num1Str.charAt(1)) +String.valueOf(num1Str.charAt(0));

        String reverseNum2Str = String.valueOf(num2Str.charAt(2))+String.valueOf(num2Str.charAt(1)) +String.valueOf(num2Str.charAt(0));

        int reverseNum1 = Integer.parseInt(reverseNum1Str);
        int reverseNum2 = Integer.parseInt(reverseNum2Str);

        if(reverseNum1>reverseNum2)
            bw.write(String.valueOf(reverseNum1));
        else
            bw.write(String.valueOf(reverseNum2));

        bw.flush();
        bw.close();
        br.close();
    }
}
