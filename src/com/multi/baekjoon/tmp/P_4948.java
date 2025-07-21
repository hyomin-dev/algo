package com.multi.baekjoon.tmp;


import java.io.*;

public class P_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int n = Integer.parseInt(br.readLine());

            if(n==0)
                break;
            if(n==1)
                bw.write("1\n");
            else{
                int count = 0;
                for(int nn=n+1;nn<=2*n;nn++){

                    int rootN = (int)Math.sqrt(nn);
                    boolean isPrimeNumber = true;
                    for(int i=2;i<=rootN;i++){
                        if(nn%i==0){
                            isPrimeNumber = false;
                            break;
                        }
                    }

                    if(isPrimeNumber)
                        count++;
                }

                bw.write(count+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
