package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_1927 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        while(n>0){

            int x = Integer.parseInt(br.readLine());

            if(x==0){
                if(q.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(q.poll()+"\n");
            }else{
                q.offer(x);
            }

            n--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
