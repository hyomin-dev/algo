package com.multi.baekjoon.brute_force;


import java.io.*;
import java.util.StringTokenizer;

public class P_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 0 <=n <= 500,000

        int m = Integer.parseInt(br.readLine()); // 0 <= m <= 10


        if(m==0){ // 고장난 버튼이 없는 경우
            int buttonTopDown = Math.abs(n-100);
            int buttonNumber = String.valueOf(n).length();

            int result = buttonTopDown > buttonNumber ? buttonNumber : buttonTopDown;
            bw.write(String.valueOf(result));
        }else{

            StringTokenizer st = new StringTokenizer(br.readLine());
            String brokenButtons = "";

            for(int i=0;i<m;i++)
                brokenButtons += st.nextToken();

            int minValue = Integer.MAX_VALUE;
            int buttonTopDown = Math.abs(n-100);

            for(int num=0;num<9999999;num++){
                boolean isContainBrokenButton = false;
                for(int idx=0;idx<brokenButtons.length();idx++){
                    if(String.valueOf(num).contains(String.valueOf(brokenButtons.charAt(idx)))) {
                        isContainBrokenButton = true;
                        break;
                    }
                }
                if(isContainBrokenButton)
                    continue;
                else{
                    if(n==num){
                        int buttonNumber = String.valueOf(num).length();
                        if(buttonNumber<minValue) {
                            minValue = buttonNumber;
                            break;
                        }
                    }else{
                        int buttonNumber = String.valueOf(num).length();
                        int buttonNumberWithTopDown = Math.abs(n-num);
                        if(buttonNumber+buttonNumberWithTopDown<minValue)
                            minValue = buttonNumber + buttonNumberWithTopDown;

                    }
                }
            }

            int result = buttonTopDown > minValue ? minValue : buttonTopDown;

            bw.write(String.valueOf(result));

        }


        bw.flush();
        bw.close();
        br.close();

    }
}
