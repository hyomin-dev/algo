package com.multi.baekjoon.stack_queue;


import java.io.*;
import java.util.ArrayList;

public class P_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        int i=0;
        while (i < k) {

            int num = Integer.parseInt(br.readLine());

            if(num==0){
                list.remove(list.size()-1);
            }else
                list.add(num);
            i++;
        }

        int sum = 0;
        for(Integer num:list)
            sum+=num;

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();

    }
}

/*
*
* 재민: 장부 관리
* 재현: 재민 도와서 장부 관리, 실수 자주 함
* 잘못된 수 부를 때 마다 0을 외침
*
* 1, 6
* */
