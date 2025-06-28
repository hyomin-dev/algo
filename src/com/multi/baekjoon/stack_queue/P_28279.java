package com.multi.baekjoon.stack_queue;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int n = Integer.parseInt(br.readLine());

        int i =0;

        ArrayList<Integer> list = new ArrayList<>();
        while(i<n){

            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("1")){

                int x = Integer.parseInt(st.nextToken());
                list.add(x);

            }else if(command.equals("2")){

                if(list.isEmpty())
                    bw.write("-1");
                else {
                    int num = list.get(list.size()-1);
                    list.remove(list.size()-1);
                    bw.write(String.valueOf(num));
                }
                bw.newLine();

            }else if(command.equals("3")){

                bw.write(String.valueOf(list.size()));
                bw.newLine();

            }else if(command.equals("4")){

                if(list.isEmpty())
                    bw.write("1");
                else
                    bw.write("0");

                bw.newLine();

            }else if(command.equals("5")){

                if(list.isEmpty())
                    bw.write("-1");
                else
                    bw.write(String.valueOf(list.get(list.size()-1)));
                bw.newLine();
            }

            i++;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
