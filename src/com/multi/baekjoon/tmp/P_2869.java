package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.StringTokenizer;

public class P_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int day = 1;
        int firstDay = a;
        int moveDay = a-b;

        if(a==v)
            bw.write("1");
        else{
            int rest = v-a;
            if(rest%(a-b)==0){
                bw.write(String.valueOf(rest/(a-b)+1));

            }else{
                bw.write(String.valueOf(rest/(a-b)+2));

            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

/*

낮: A 미터 올라감
밤: B 미터 떨어짐

1: +2 = 2
2: -1 +2 = 1
3: -1 +2 = 1
4: -1 +2 = 1

1: +2 -1 = 1
2: 1
3: 1
4: +2

1:


1: A
2: A+(-B+A)
3: A+(-B+A) + (-B+A)

*
* */