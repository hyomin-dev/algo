package com.multi.baekjoon.tmp;

/*
import java.io.*;
import java.util.ArrayList;

public class P_4134 {

    static ArrayList<Long> list = new ArrayList<>();
    static ArrayList<Long> nList = new ArrayList<>();
    static long n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        long maxN = -1;
        while(t>0){

            n = Long.parseLong(br.readLine());
            if(maxN<n)
                maxN = n;

           nList.add(n);

            t--;
        }

        findPrimeNumberInRootN(maxN);

        for(Long num: nList){

            if(num<=2)
                bw.write("2");
            else if(num==3)
                bw.write("3");
            else{

                long result = num;
                while(true){
                    boolean isFind = true;
                    for(int i=0;i<list.size();i++){
                        if(list.get(i)==result){
                            break;
                        } else if(result%list.get(i)==0){
                            isFind = false;
                            break;
                        }
                    }

                    if(isFind){
                        break;
                    }else
                        result++;
                }
                bw.write(result+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void findPrimeNumberInRootN(long n){
        long rootN = (long)Math.sqrt(n);

        for(long i=2;i<=rootN;i++){
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
}*/

import java.io.*;

public class P_4134{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){
            long n = Long.parseLong(br.readLine());

            if(n<=1){
                bw.write("2\n");
            }else {
                while(true){

                    long rootN = (long)(Math.sqrt(n));
                    boolean isFind = true;
                    for(long i=2;i<=rootN;i++){
                        if(n%i==0){
                            isFind = false;
                            break;
                        }
                    }

                    if(isFind)
                        break;
                    else
                        n++;
                }
                bw.write(n+"\n");
            }

            t--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
