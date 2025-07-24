package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_14888 {

    static int n; // 2 <= n <= 11
    static int[] array;
    static int[] operations ; // 덧셈, 뺄셈, 곱셉, 나눗셈의 개수
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        array = new int[n];
        operations = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<4;i++) {
           int num = Integer.parseInt(st.nextToken());
           operations[i] = num;
        }

        for(int oper=0;oper<4;oper++){ // 4가지 연산중에 선택
            if(operations[oper]>0){
                operations[oper] -=1;
                int sum = 0;
                sum = calc(oper,array[0],array[1]);
                search(sum, 0+1); // 현재는 depth가 0임
                operations[oper] +=1;
            }
        }

        bw.write(maxValue+"\n");
        bw.write(minValue+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int sum, int depth){
        if(depth==n-1){
            if(minValue>sum)
                minValue = sum;

            if(maxValue<sum)
                maxValue = sum;

            return;
        }

        for(int oper=0;oper<4;oper++){
            if(operations[oper]>0){

                operations[oper] -=1; // 연산 차감
                int result = calc(oper,sum,array[depth+1]);

                search(result,depth+1);

                operations[oper] +=1; // 연산 복원
            }
        }
    }

    static int calc(int oper, int prev, int next){
        int sum = 0;
        switch (oper){
            case 0:{
                sum += prev + next;
                break;
            }
            case 1:{
                sum += prev - next;
                break;
            }
            case 2:{
                sum += prev * next;
                break;
            }
            case 3:{
                // 각 원소는 1 <= element <= 100
                if(prev<0){
                    int tmp = (prev*-1)/next;
                    tmp = tmp*-1;
                    sum +=tmp;
                }else
                    sum += prev/next;

                break;
            }
        }

        return sum;
    }
}

/*
연산을 백트래킹하는 방식으로 진행

* */
