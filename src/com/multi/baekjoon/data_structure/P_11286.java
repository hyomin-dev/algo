package com.multi.baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class P_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Element> pq = new PriorityQueue<>();
        while(n>0){
            int x = Integer.parseInt(br.readLine());

            if(x==0){
                if(pq.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(pq.poll().getValue()+"\n");
            }else{
                pq.offer(new Element(x));
            }

            n--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Element implements Comparable<Element>{
    int value;

    public Element(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public int compareTo(Element o){

        int absValue = Math.abs(this.value);
        int otherAbsValue = Math.abs(o.getValue());

        if(absValue!=otherAbsValue){
            return absValue - otherAbsValue;
        }else{
            return this.value-o.getValue();
        }

    }
}