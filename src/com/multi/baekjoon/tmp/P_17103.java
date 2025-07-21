package com.multi.baekjoon.tmp;

/*

import java.io.*;
import java.util.ArrayList;

public class P_17103 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            int count = 0;

            int primeNumber = 2;
           while(true){

               // 왼쪽 소수가 n의 절반 보다 큰 경우 이미 앞에서 카운트 함
               if(primeNumber>n/2)
                   break;

               // 왼쪽 소수 후보가 2가 아닌데 짝수 인 경우 1 증가
               if(primeNumber!=2&&primeNumber%2==0) {
                   primeNumber++;
                   continue;
               }

               // primeNumber가 소수인지 판별
               boolean isPrimeNumber = true;
               int rootPrimeNumber = (int)Math.sqrt(primeNumber);
               for(int i=2;i<=rootPrimeNumber;i++){
                   if(primeNumber%i==0){
                       isPrimeNumber = false;
                       break;
                   }
               }

               // 소수가 아니라면 1 증가
               if(!isPrimeNumber){
                   primeNumber++;
                   continue;
               }


               int restPrimeNumber = n-primeNumber;

                // restPrimeNumber가 소수인지 판별
               isPrimeNumber = true;
               int rootRestPrimeNumber = (int)Math.sqrt(restPrimeNumber);

               for(int i=2;i<=rootRestPrimeNumber;i++){
                   if(restPrimeNumber%i==0){
                       isPrimeNumber = false;
                       break;
                   }
               }

               //restPrimeNumber도 소수라면 카운트
               if(isPrimeNumber)
                   count++;

               primeNumber++;
           }

           bw.write(count+"\n");

            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class P_17103 {
    static boolean[] array;
    static ArrayList<Integer> nList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int maxN = Integer.MIN_VALUE;
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            nList.add(n);
            if(n>maxN)
                maxN = n;
            t--;
        }
        array = new boolean[maxN+1];
        Arrays.fill(array,true);
        findPrimeNumber(maxN);

        for(int num: nList){
            int count = 0;

            for(int i=0;i<=num;i++){
                if(array[i]){
                    if(i>num/2)
                        break;
                    else{
                        int restPrimeNumber = num-i;
                        if(array[restPrimeNumber])
                            count++;
                    }
                }
            }

            bw.write(count+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void findPrimeNumber(int n){
        int rootN = (int)Math.sqrt(n);

        array[0] = false;
        array[1] = false;

        for(int i=2;i<=rootN;i++){
            if(array[i]){
                int j=2;
                while(i*j<=n){
                    if(array[i*j])
                        array[i*j] = false;
                    j++;
                }
            }
        }
    }
}
