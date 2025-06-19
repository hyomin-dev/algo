package com.multi.baekjoon.charandstring;


import java.io.*;

public class P_27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        Integer num = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(str.charAt(num-1)));
        bw.flush();
        bw.close();
        br.close();

    }

}
