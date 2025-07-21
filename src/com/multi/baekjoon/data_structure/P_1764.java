package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        TreeMap<String,Integer> map1 = new TreeMap<>();

        TreeMap<String,Integer> map2 = new TreeMap<>();

        for(int i=0;i<n;i++)
            map1.put(br.readLine(),1);

        int count = 0;
        for(int i=0;i<k;i++) {
            String key = br.readLine();
            map2.put(key, map1.getOrDefault(key, 0));

            int value = map2.get(key);
            if(value>0)
                count++;
        }
        bw.write(count+"\n");

        Set<String> keySet = map2.keySet();
        Iterator<String> keyIterator = keySet.iterator();

        while(keyIterator.hasNext()){
            String key = keyIterator.next();
            Integer value = map2.get(key);

            if(value>0)
                bw.write(key+"\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
