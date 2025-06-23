package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int i= 0;
        List<Integer> list = new ArrayList<>();

        while(i<num){

            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch(command){
                case "push_front":{
                    int val = Integer.parseInt(st.nextToken());
                    list.add(0,val);
                    break;
                }
                case "push_back":{
                    int val = Integer.parseInt(st.nextToken());
                    list.add(val);
                    break;
                }
                case "pop_front":{
                    if(list.isEmpty())
                        bw.write("-1");
                    else {
                        bw.write(String.valueOf(list.get(0)));
                        list.remove(0);
                    }
                    bw.newLine();
                    break;
                }
                case "pop_back":{
                    if(list.isEmpty())
                        bw.write("-1");
                    else {
                        bw.write(String.valueOf( list.get(list.size()-1)));
                        list.remove(list.size()-1);
                    }
                    bw.newLine();
                    break;
                }
                case "size":{
                    bw.write(String.valueOf(list.size()));
                    bw.newLine();
                    break;
                }
                case "empty":{
                    if(list.isEmpty())
                        bw.write("1");
                    else
                        bw.write("0");
                    bw.newLine();
                    break;
                }
                case "front":{
                    if(list.isEmpty())
                        bw.write("-1");
                    else
                        bw.write(String.valueOf(list.get(0)));
                    bw.newLine();
                    break;
                }
                case "back":{
                    if(list.isEmpty())
                        bw.write("-1");
                    else
                        bw.write(String.valueOf(list.get(list.size()-1)));
                    bw.newLine();
                    break;
                }
            }
            i++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
