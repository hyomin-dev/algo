package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class P_11653 {

    static int n;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        if(n!=1){
            findPrimeNumber(); // 에라토스테네스의 체를 이용, rootN까지 소수를 구함


            if(q.isEmpty())
                bw.write(String.valueOf(n));
            else{
                while(n!=1){
                    int x=1;
                    if(!q.isEmpty())
                        x = q.poll();
                    else {
                        bw.write(n +"\n");
                        break;
                    }

                    while(true){
                        if(n%x!=0)
                            break;
                        else {
                            bw.write(x + "\n");
                            n = n/x;
                        }
                    }
                }
            }

            bw.flush();
            bw.close();
            br.close();
        }

    }

    static void findPrimeNumber(){

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
                q.offer(i);
        }
    }
}
