package com.multi.baekjoon.tmp;
import java.io.*;
import java.util.*;

public class P_5525 {
    static int n,m, findStrLength;
    static int count = 0;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        s = br.readLine();

        findStrLength = 2*n+1;
        count = 0;

        int i=0;
        while(i<=m-findStrLength){
            if(s.charAt(i)=='O'){
                i++;
            }else{
                boolean result = findStr(i);
                if(result) {
                    i += 2;
                    count++;
                }else{
                    i++;
                }
                while(result){
                    if(i+2*(n-1)+2>=m)
                        break;

                    if(s.charAt(i+2*(n-1)+1)=='O'&&s.charAt(i+2*(n-1)+2)=='I') {
                        i+=2;
                        count++;
                        result = true;
                    }
                    else{
                        i = i+2*(n-1);
                        result = false;
                    }

                }

            }
        }

        bw.write(count+"");

        bw.flush();
        bw.close();
        br.close();
    }
    static boolean findStr(int startIdx){

        int oiCount = 0;
        int idx = startIdx;
        while(true){

            if(oiCount==n) {
                break;
            }

            if(s.charAt(idx+1)=='O'&&s.charAt(idx+2)=='I') {
                oiCount++;
                idx += 2;
            } else
                return false;
        }

        return true;

    }
}
