package com.multi.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class P_1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Character> signList = new ArrayList<>();

        if(str.charAt(0)!='-')
            signList.add('+');

        for(int i=0;i<str.length();i++){

            if(str.charAt(i)=='+'){
                if(sb.length()!=0){
                    int num = Integer.parseInt(sb.toString());
                    numList.add(num);
                    sb = new StringBuilder();
                }
                signList.add('+');

            }else if(str.charAt(i)=='-'){
                if(sb.length()!=0){
                    int num = Integer.parseInt(sb.toString());
                    numList.add(num);
                    sb = new StringBuilder();
                }
                signList.add('-');

            }else {
                sb.append(str.charAt(i));
            }

            if(i==str.length()-1){
                if(sb.length()!=0){
                    int num = Integer.parseInt(sb.toString());
                    numList.add(num);
                }
            }
        }

        int sum = 0; // 최종 합을 저장하는 변수
        int tmp = 0; // '-'를 만났을 때 부터 '-'를 만날 때 까지 저장하는 변수
        int idx = 0; // 숫자와 부호 index
        int stage = 0; // 0: 아직 -를 만나지 않음, 1: -를 처음 만남

        /*
        * -를 처음 만나면 tmp에 숫자만 더해 줌
        * -를 두번째 만나면 tmp에 있는 숫자에 -1를 곱해서 더해 줌
        * */

        if(signList.get(0)=='-')
            stage =1;

        for(char sign: signList){
            if(sign=='+'){
                if(stage==0){
                    sum +=numList.get(idx);
                }else if(stage==1){
                    tmp +=numList.get(idx);
                }
            }else{
                if(stage==1){ // 이미 -를 만났는데 또 만남
                    sum +=tmp*-1;
                    tmp = 0;
                    tmp +=numList.get(idx);

                }else{
                    tmp = 0 ;
                    tmp+=numList.get(idx);
                    stage = 1;
                }
            }

            if(idx==numList.size()-1){
                tmp = tmp*-1;
                sum +=tmp;
            }

            idx++;
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();

    }
}
