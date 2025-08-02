package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_9019 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            String result = bfs(a,b);
            bw.write(result);
            bw.newLine();
            t--;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static String bfs(int a, int b){
        String result = "";

        boolean[] visited = new boolean[10000];
        visited[a] = true;

        Queue<Data9019> queue = new ArrayDeque<>();
        queue.offer(new Data9019(a,""));

        while(!queue.isEmpty()){

            Data9019 data = queue.poll();

            if(data.num==b){
                return data.oper;
            }

            //D
            int operD = data.num*2 %10000;
            if(!visited[operD]) {
                queue.offer(new Data9019(operD, data.oper+"D" ));
                visited[operD] = true;
            }

            //S
            int operS = data.num==0 ? 9999 : data.num-1;
            if(!visited[operS]) {
                queue.offer(new Data9019(operS,  data.oper+"S"));
                visited[operS] = true;
            }

            //L

            int operL = (data.num%1000)*10+data.num/1000;
            if(!visited[operL]) {
                queue.offer(new Data9019(operL, data.oper+"L"));
                visited[operL] = true;
            }

            //R

            int operR = data.num/10 +(data.num%10)*1000;
            if(!visited[operR]) {
                queue.offer(new Data9019(operR, data.oper+"R"));
                visited[operR] = true;
            }
        }
        return result;

    }
}

class Data9019{
    int num;
    String oper;

    public Data9019(int num,  String oper){
        this.num = num;
        this.oper = oper;
    }
}
