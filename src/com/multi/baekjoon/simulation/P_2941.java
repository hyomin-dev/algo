package com.multi.baekjoon.simulation;


import java.io.*;

public class P_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int start = 0;
        int count = 0;

        while(start<=str.length()-1){

            String subStr = null;
            if(start<=str.length()-2)
                subStr = str.substring(start,start+2);

            if(subStr!=null&&(subStr.equals("c=")||subStr.equals("c-")||subStr.equals("d-")||subStr.equals("lj")||subStr.equals("nj")||subStr.equals("s=")||subStr.equals("z="))){
                start +=2;
                count++;
            }else if(subStr!=null&&start<=str.length()-3&&subStr.equals("dz")&&str.charAt(start+2)=='=') {
                    start += 3;
                    count++;

            }else{
                count++;
                start++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
