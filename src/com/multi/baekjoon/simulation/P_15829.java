package com.multi.baekjoon.simulation;

import java.io.*;
import java.util.*;

public class P_15829 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(br.readLine());

        String s = br.readLine();

        long r = 31;
        long moduler = 1234567891;

        long sum = 0;

        for(int i=0;i<l;i++){
            long num = s.charAt(i)-'a' +1;

            if(i==0){
                long result = num%moduler;
                sum +=result;
            }else if(i==1){
                long result = (num*r)%moduler;
                sum +=result;
            }
            else{

                r = (r*31)%moduler;
                long result = (num*r)%moduler;
                sum += result;

            }

        }

        bw.write(sum%moduler+"");

        bw.flush();
        bw.close();
        br.close();


    }
}
