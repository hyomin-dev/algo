package com.multi.baekjoon.cumulative_sum_analysis;

import java.io.*;
import java.util.*;

public class P_12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String dna = br.readLine();

        int[] countArray = new int[4]; // A C G T의 개수
        int[] countAns = new int[4]; // 조건
        int psCount = 1; // 비밀번호 개수

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++)
            countAns[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<p;i++){
            char c = dna.charAt(i);

            if(c=='A')
                countArray[0] +=1;
            else if(c=='C')
                countArray[1] +=1;
            else if(c=='G')
                countArray[2] +=1;
            else if(c=='T')
                countArray[3] +=1;
        }

        for(int i=0;i<4;i++){
            if(countAns[i]>countArray[i]){
                psCount = 0;
                break;
            }
        }

        for(int i=p;i<s;i++){
            char removeC = dna.charAt(i-p);
            char addC = dna.charAt(i);

            if(removeC=='A')
                countArray[0] -=1;
            else if(removeC=='C')
                countArray[1] -=1;
            else if(removeC=='G')
                countArray[2] -=1;
            else if(removeC=='T')
                countArray[3] -=1;

            if(addC=='A')
                countArray[0] +=1;
            else if(addC=='C')
                countArray[1] +=1;
            else if(addC=='G')
                countArray[2] +=1;
            else if(addC=='T')
                countArray[3] +=1;

            psCount +=1;
            for(int j=0;j<4;j++){
                if(countAns[j]>countArray[j]){
                    psCount -= 1;
                    break;
                }
            }
        }

        bw.write(psCount+"");

        bw.flush();
        bw.close();
        br.close();

    }
}
