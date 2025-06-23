package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int i=0;
        List<Integer> list = new ArrayList<>();
        while(i<num){

            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if(command.equals("push")){
                list.add(Integer.parseInt(st.nextToken()));
            }else if(command.equals("top")){
                if(list.isEmpty())
                    bw.write(String.valueOf("-1"));
                else
                    bw.write(String.valueOf(list.get(list.size()-1)));
                bw.newLine();
            }else if(command.equals("size")){
                bw.write(String.valueOf(list.size()));
                bw.newLine();
            }else if(command.equals("empty")){
                if(list.isEmpty())
                    bw.write("1");
                else
                    bw.write("0");
                bw.newLine();
            }else{
                if(list.isEmpty())
                    bw.write("-1");
                else{
                    bw.write(String.valueOf(list.get(list.size()-1)));
                    list.remove(list.size()-1);
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
