package com.multi.baekjoon.dp;


import java.io.*;

public class P_15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            if(n<=2)
                bw.write(n+"\n");
            else if(n==3)
                bw.write(4+"\n");
            else{
                long[] array = new long [n+1];
                array[1] = 1;
                array[2] = 2;
                array[3] = 4;
                for(int j=4;j<=n;j++)
                    array[j] = (array[j-1]+array[j-2]+array[j-3])%1000000009;
                bw.write(array[n]+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

/*
1%3 = 1
2%3 = 2
4%3= 1
7%3= 1
13%3=1
24%3= 0
44%3= 2
81%3=0
149%3 = 2
274%3 = 1
이 규칙을 이용

*
* */
