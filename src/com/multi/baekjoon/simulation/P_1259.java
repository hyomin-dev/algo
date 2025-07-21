package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.*;

public class P_1259 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String num = br.readLine();
            if(num.equals("0"))
                break;

            int start = 0;
            int end = num.length()-1;

            boolean isPalindrome = true;
            for(int i=0;i<num.length()/2;i++){
                if(num.charAt(start+i)!=num.charAt(end-i)){
                    isPalindrome = false;
                    break;
                }
            }

            if(isPalindrome)
                bw.write("yes\n");
            else
                bw.write("no\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

/*

1221 --> 4/2 = 2
12421 --> 5/2 = 2





*
* */
