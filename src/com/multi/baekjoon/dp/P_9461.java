package com.multi.baekjoon.dp;

import java.io.*;
import java.util.*;

public class P_9461 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){

            int n = Integer.parseInt(br.readLine());

            if(n<=3){
                bw.write("1\n");
            }else if(n<=5)
                bw.write("2\n");
            else{
                long[] array = new long[n+1];
                array[1] = 1;
                array[2] = 1;
                array[3] = 1;
                array[4] = 2;
                array[5] = 2;

                for(int i=6;i<=n;i++)
                    array[i] = array[i-1] + array[i-5];

                bw.write(array[n]+"\n");
            }
            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

/*

1 1 1 2 2 3 4 5 7 9 12 16 21

3칸을 띄어 넘어서 더하면됨

i>=6
p[i] = p[i-1] + p[i-5]


*
*
*
* */
