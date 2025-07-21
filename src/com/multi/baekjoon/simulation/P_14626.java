package com.multi.baekjoon.simulation;

import java.io.*;
import java.util.*;

public class P_14626 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int idx = -1;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='*'){
                idx = i;
                break;
            }

        }

        if(idx==str.length()-1){
            int sum = 0;
            for(int i=0;i<str.length()-1;i++){
                if(i%2==0)
                    sum +=str.charAt(i)-'0';
                else
                    sum +=(str.charAt(i)-'0')*3;
            }

            for(int i=0;i<10;i++){
                if((sum+i)%10==0){
                    bw.write(i+"");
                    break;
                }
            }
        }else{
            int sum = str.charAt(str.length()-1) - '0';
            for(int i=0;i<str.length()-1;i++){
                if(i==idx)
                    continue;
                else{
                    if(i%2==0)
                        sum +=str.charAt(i)-'0';
                    else
                        sum +=(str.charAt(i)-'0')*3;
                }
            }

            for(int i=0;i<10;i++){
                if(idx%2==0&&(sum+i)%10==0) {
                    bw.write(i + "");
                    break;
                }else if(idx%2!=0&&(sum+i*3)%10==0) {
                    bw.write(i + "");
                    break;
                }
            }

        }

        bw.flush();
        bw.close();
        br.close();

    }
}

/*

9+3*7+8+8*3+9+6*3+8+3*3+2+2*3+7*3 = 135
* */
