package com.multi.baekjoon.data_structure;


import java.io.*;
import java.util.*;

public class P_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        TreeSet<String> treeSet = new TreeSet<>(Collections.reverseOrder());

        while(n>0){

            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String status = st.nextToken();

            if(status.charAt(0)=='e'){
                treeSet.add(name);
            }else{
                treeSet.remove(name);
            }
            n--;
        }

        for(String name: treeSet){
            bw.write(name+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
