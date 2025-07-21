package com.multi.baekjoon.stack_queue;


import java.io.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P_28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int n = Integer.parseInt(br.readLine());

        int i =0;

        Deque<Integer> deque = new LinkedList<>();
        while(n>0){

            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("1")){

                int x = Integer.parseInt(st.nextToken());
                deque.offerFirst(x);

            }else if(command.equals("2")){

                int x = Integer.parseInt(st.nextToken());
                deque.offerLast(x);

            }else if(command.equals("3")){

                if(deque.isEmpty())
                    bw.write("-1");
                else
                    bw.write(String.valueOf(deque.pollFirst()));

                bw.newLine();

            }else if(command.equals("4")){

                if(deque.isEmpty())
                    bw.write("-1");
                else
                    bw.write(String.valueOf(deque.pollLast()));

                bw.newLine();

            }else if(command.equals("5")){

                bw.write(String.valueOf(deque.size()));
                bw.newLine();
            } else if(command.equals("6")){

                if(deque.isEmpty())
                    bw.write("1");
                else
                    bw.write("0");

                bw.newLine();
            }else if(command.equals("7")){
                if(deque.isEmpty())
                    bw.write("-1");
                else
                    bw.write(String.valueOf(deque.peekFirst()));

                bw.newLine();
            }else if(command.equals("8")){
                if(deque.isEmpty())
                    bw.write("-1");
                else
                    bw.write(String.valueOf(deque.peekLast()));

                bw.newLine();
            }

            n--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
