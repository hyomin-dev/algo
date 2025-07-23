package com.multi.baekjoon.simulation;

import java.io.*;
import java.util.*;

public class P_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        if(x==1)
            bw.write("1/1");
        else{
            int start = 2;
            int end = 3;
            int num = 2; // 구간에 숫자 개수, 구간 번호


            /*
            * 1
            * 2~3
            * 4~6
            * 7~10
            *
            * start ~ end, num++
            * */

            while(true){
                if(start<=x&&x<=end){ // x가 속한 구간을 찾음
                    int order = x-start+1;

                    if(num%2==0){ // 구간에 속한 숫자가 짝수: 위 → 아래
                        //num-order+1이 분자가 됨
                        // order이 분모가 됨
                        bw.write(order+"/"+(num-order+1));

                    }else{ // 구간에 속한 숫자가 홀수: 아래 → 위

                        // (num-order+1)이 분모가 됨
                        // order이 분자가 됨
                        bw.write((num-order+1)+"/"+order);
                    }

                    break;

                }else{
                    num++;
                    start = end+1;
                    end = start+ num -1;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
