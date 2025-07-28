package com.multi.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class P_1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Meeting> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Meeting(start, end));
        }

        Collections.sort(list);

        ArrayList<Meeting> selectedList = new ArrayList<>(); // 선택된 회의를 담는 리스트

        selectedList.add(list.get(0)); //끝나는 시간이 가장 빠른 회의를 담는다.

        int k=0; //마지막으로 선택된 회의의 인덱스

        for(int i=1;i<n;i++){
            if(list.get(i).getStart()>=list.get(k).getEnd()){
                selectedList.add(list.get(i));
                k = i;
            }
        }

        bw.write(selectedList.size()+"");

        bw.flush();
        bw.close();
        br.close();

    }
}

class Meeting implements Comparable<Meeting>{
    private int start;
    private int end;

    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }

    int getStart(){
        return this.start;
    }

    int getEnd(){
        return this.end;
    }

    @Override
    public int compareTo(Meeting o){
        // 회의 끝나는 시간을 기준으로 오름차순으로 정렬한다.

        if(this.end==o.end){
            return this.start - o.start;
        }else
            return this.end - o.end;
    }
}

/*
반례:
3
2 2
1 2
2 3

회의 끝나는 시간이 같을 경우 --> 회의 시작 시간을 기준으로 오름차순 정렬

* */
