package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_9375 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int t = Integer.parseInt(br.readLine());
        while(t>0){

            int n = Integer.parseInt(br.readLine());
            Map<String,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String key = st.nextToken();
                map.put(key,map.getOrDefault(key,0)+1);
            }

            int result = 1;
            Set<String> keySet = map.keySet();
            Iterator<String> iterator = keySet.iterator();

            while(iterator.hasNext()){
                String key = iterator.next();
                result *=(map.get(key)+1);
            }

            bw.write(String.valueOf(result-1));
            bw.newLine();
            t--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
