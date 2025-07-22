package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){

            String commands = br.readLine();
            int num = Integer.parseInt(br.readLine());

            String s  = br.readLine();
            s = s.substring(1,s.length()-1);
            StringTokenizer st = new StringTokenizer(s,",");
            Deque<Integer> deque = new ArrayDeque<>();

            while(st.hasMoreTokens()){
                deque.offerLast(Integer.parseInt(st.nextToken()));
            }
            boolean isQueue = true; // queue --> pollFirst, stack --> pollLast
            boolean isError = false;

            for(int i=0;i<commands.length();i++){
                if(commands.charAt(i)=='R')
                    isQueue = !isQueue;
                else{
                    if(deque.isEmpty()){
                        isError = true;
                        break;
                    } else if(isQueue){
                        deque.pollFirst();
                    }else
                       deque.pollLast();
                }

            }

            if(isError)
                bw.write("error");
            else if(isQueue){
                bw.write("[");
                if(!deque.isEmpty())
                    bw.write(deque.pollFirst()+"");

                while(!deque.isEmpty()){
                    bw.write(","+deque.pollFirst());
                }
                bw.write("]");
            }else{
                bw.write("[");
                if(!deque.isEmpty())
                    bw.write(deque.pollLast()+"");
                while(!deque.isEmpty()){
                    bw.write(","+deque.pollLast());
                }

                bw.write("]");
            }
            if(t!=1)
                bw.newLine();

            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
