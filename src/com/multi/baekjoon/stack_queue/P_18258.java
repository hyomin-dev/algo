package com.multi.baekjoon.stack_queue;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int i = 0;
        int last = -1;
        Queue<Integer> q = new LinkedList<>();
        while(i<n){

            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                q.offer(x);
                last = x;

            }else if(command.equals("pop")){

                if(q.isEmpty())
                    bw.write("-1");
                else{
                    int x = q.poll();
                    bw.write(String.valueOf(x));
                    if(q.isEmpty())
                        last = -1;
                }
                bw.newLine();

            }else if(command.equals("size")){

                bw.write(String.valueOf(q.size()));
                bw.newLine();

            }else if(command.equals("empty")){

                if(q.isEmpty())
                    bw.write("1");
                else
                    bw.write("0");
                bw.newLine();

            }else if(command.equals("front")){

                if(q.isEmpty())
                    bw.write("-1");
                else
                    bw.write(String.valueOf(q.peek()));

                bw.newLine();

            }else if(command.equals("back")){

                if(q.isEmpty())
                    bw.write("-1");
                else{
                    bw.write(String.valueOf(last));
                }
                bw.newLine();

            }
            i++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
