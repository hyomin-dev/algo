package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_9663 {

    static int n;
    static int count = 0;
    static int[] selects;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        selects = new int[n+1];

        int depth = 1;
       for(int x=0;x<n;x++){
           selects[1] = x;
           search(depth+1); // 첫 번째 행이 depth가 1임
       }

        bw.write(count+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int depth){
        if(depth==n+1) {
            count++;
            return;
        }

        for(int x=0;x<n;x++){
            boolean isSelected = true;
            for(int i=1;i<depth;i++){
                int sel = selects[i];
                if(sel==x){ // 각 행에서 선택한 퀸이 아래 방향으로 공격할 수 있는 위치에 있음
                    isSelected = false;
                    break;
                }else if(sel-(depth-i)==x){ // 각 행에서 선택한 퀸이 공격할 수 있는 x의 위치, 한칸 씩 내려갈 때 마다 왼쪽 오른쪽으로 한칸씩 대각선의 x위치가 증가함
                    isSelected = false;
                    break;
                }else if(sel+(depth-i)==x){ // 각 행에서 선택한 퀸이 공격할 수 있는 x의 위치, 한칸 씩 내려갈 때 마다 왼쪽 오른쪽으로 한칸씩 대각선의 x위치가 증가함
                    isSelected = false;
                    break;
                }
            }
            if(isSelected){
                selects[depth] = x;
                search(depth+1);
            }
        }
    }
}

/*

NXN에 N개의 퀸이 서로 공격할 수 없게 놓아야함
--> 퀸의 특성상 한 행 당 하나만 놓을 수 있음

* */