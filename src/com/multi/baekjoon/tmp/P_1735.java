package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.StringTokenizer;

public class P_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1Up = Integer.parseInt(st.nextToken());
        int n1Down = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n2Up = Integer.parseInt(st.nextToken());
        int n2Down = Integer.parseInt(st.nextToken());

        int nDown = 1;
        for(int i=1;i<=n1Down*n2Down;i++){
            if(i%n1Down==0&&i%n2Down==0){
                nDown = i;
                break;
            }
        }

        int nUp = n1Up*(nDown/n1Down) + n2Up*(nDown/n2Down);

        int end = Math.min(nUp,nDown);
        for(int i=end;i>=2;i--){
            if(nUp%i==0&&nDown%i==0){
                nUp = nUp/i;
                nDown = nDown/i;
                break;
            }
        }

        bw.write(nUp+" "+nDown);

        bw.flush();
        bw.close();
        br.close();

    }
}
