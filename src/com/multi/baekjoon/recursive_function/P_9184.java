package com.multi.baekjoon.recursive_function;

import java.io.*;
import java.util.*;

public class P_9184 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());

            if(a==-1&&b==-1&&c==-1)
                break;
            else{
                int result = w(a,b,c);
                bw.write("w("+a+", "+b+", "+c+") = "+result+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static int w(int a, int b, int c){
        if(a<=0||b<=0||c<=0)
            return 1;
        else if(a>20 || b>20 || c>20)
            return w(20,20,20);
        else if (a<b && b<c)
            return w(a,b,c-1)+ w(a,b-1,c-1) - w(a,b-1,c);
        else
            return w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1)-w(a-1,b-1,c-1);
    }
}
