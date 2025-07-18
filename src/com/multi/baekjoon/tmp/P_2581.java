package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.ArrayList;

public class P_2581 {

    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        findPrimeNumber(n); //에라토스테네스의 체
        int sum = 0;
        int minValue = n;

        for(int i=m;i<=n;i++){
            if(i==1)
                continue;

            boolean isPrimeNumber = true;

            for(int j=0;j<list.size();j++){ // 에라토스테네스의 체
                if(list.get(j)==i){ // root n 이하의 소수와 같은 경우 --> i는 소수
                    break;
                } else if(i%list.get(j)==0){ // root n 이하의 소수의 배수 인 경우 --> i는 소수가 아님
                    isPrimeNumber = false;
                    break;
                }
                // 나머지는 소수
            }

            if(isPrimeNumber){
                if(minValue>i)
                    minValue = i;
                sum +=i;
            }

        }

        if(sum==0){
            bw.write("-1");
        }else{
            bw.write(sum+"\n");
            bw.write(minValue+"");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void findPrimeNumber(int n){

        int rootN = (int)Math.sqrt(n);

        for(int i=2;i<=rootN;i++){
            boolean isPrimeNumber = true;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    isPrimeNumber = false;
                    break;
                }
            }
            if(isPrimeNumber)
                list.add(i);

        }
    }
}
