package com.multi.baekjoon._2DArray;


import java.io.*;


public class P_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] array = new String[5];

        int maxLength = 0;
        for(int i=0;i<5;i++) {
            array[i] = br.readLine();
            if(maxLength<array[i].length())
                maxLength = array[i].length();
        }

        for(int i=0;i<maxLength;i++){
            for(int j=0;j<5;j++){
                if(array[j].length()<=i)
                    continue;
                else
                    bw.write(array[j].charAt(i));

            }
        }
        bw.flush();
        bw.close();
        br.close();



    }
}
