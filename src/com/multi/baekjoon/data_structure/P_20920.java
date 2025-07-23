package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        while(n>0){
            n--;
            String str = br.readLine();

            if(str.length()<m)
                continue;

            map.put(str, map.getOrDefault(str,0)+1);

        }

        Set<String> keySet = map.keySet();
        ArrayList<Data> dataList = new ArrayList<>();
        for(String key: keySet){
            Data data = new Data(key, map.get(key));
            dataList.add(data);
        }

        Collections.sort(dataList);

        for(Data word: dataList){
            bw.write(word.str+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

class Data implements Comparable<Data>{
    String str;
    int count;

    public Data(String str, int count){
        this.str = str;
        this.count = count;
    }

    @Override
    public int compareTo(Data o){
        if(this.count!=o.count){
            return o.count - this.count;
        }else if(this.str.length()!=o.str.length()){
            return o.str.length()-this.str.length();
        }else{
            return this.str.compareTo(o.str);
        }
    }
}
