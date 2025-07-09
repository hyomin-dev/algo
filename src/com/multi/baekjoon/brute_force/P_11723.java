package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new HashSet<>();

        int m = Integer.parseInt(br.readLine());

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            switch(command){
                case "add":{
                    int x = Integer.parseInt(st.nextToken());
                    set.add(x);
                    break;
                }
                case "remove":{
                    int x = Integer.parseInt(st.nextToken());
                    set.remove(x);
                    break;
                }
                case "check":{
                    int x = Integer.parseInt(st.nextToken());
                    if(set.contains(x))
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                }
                case "toggle":{
                    int x = Integer.parseInt(st.nextToken());
                    if(set.contains(x))
                        set.remove(x);
                    else
                        set.add(x);
                    break;
                }
                case "all":{
                    for(int j=1;j<=20;j++)
                        set.add(j);
                    break;
                }
                case "empty":{
                    set = new HashSet<>();
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
