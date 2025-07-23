package com.multi.baekjoon.divide_and_conquer;

import java.io.*;
import java.util.*;
import java.math.*;
public class P_4779 {
    static int[] powArray;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        powArray = new int[13];
        powArray[0] = 1;
        for(int i=1;i<=12;i++)
            powArray[i] = powArray[i-1]*3;

        char[] array = new char[powArray[12]+1];

        Arrays.fill(array,'-');
        String nStr;
        cantor(array, 12, 1);

        while((nStr=br.readLine())!=null&&!nStr.equals("")){

            int n = Integer.parseInt(nStr);

            for(int i=1;i<=powArray[n];i++)
                bw.write(array[i]+"");
            bw.newLine();

        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void cantor(char[] array, int n, int start){
        if(n==0)
            return;

        int nDivide3 = powArray[n-1];
        for(int i=start+nDivide3;i<start+2*nDivide3;i++)
            array[i] = ' ';

        cantor(array, n-1,start); //왼쪽
        cantor(array, n-1, start+2*nDivide3);

    }
}

/*

n=3
1~9, 10~18, 19~27 --> start: 1

1~9: 1~3, 4~6, 7~9 --> start: 1

19~27: 19~21, 22~24, 25~27 --> start: 19

* */