package com.multi.baekjoon.brute_force;


import java.io.*;

public class P_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int count = 1;
        int num=666;
        while(true){
            String numStr = String.valueOf(num);

            if(numStr.contains("666")){
                if(count==n)
                    break;
                else{
                    count++;
                }
            }
            num++;
        }

        bw.write(String.valueOf(num));
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
*
* 666, 1666, 2666, 3666, 4666, 5666, 6660, 6661, 6662, 6663, 6664,6665, 6666, 6667, 6668, 6669, 76666, 8666, 9666
* */
