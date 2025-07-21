package com.multi.baekjoon.stack_queue;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++)
            q.offer(i);
        int start=0;
        bw.write("<");
        while(!q.isEmpty()){

            int x = q.poll();
            start++;
            if(q.isEmpty())
                bw.write(x+">");
            else if(start==k){
                bw.write(x+", ");
                start = 0;
            }else{
                q.offer(x);
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

/*
queue에 1~n까지 수를 넣는다.
q에서 꺼냈을 때 카운트

카운트 == k인 경우 --> 출력, 카운트 0으로 초기화
카운트 !=k인 경우 ---> 꺼낸 값을 다시 queue에 넣는다.

*
* */
