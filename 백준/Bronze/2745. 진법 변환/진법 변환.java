import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String nStr = st.nextToken();

        int b = Integer.parseInt(st.nextToken());

        int digit = 1;
        int sum = 0;

        for(int i=nStr.length()-1;i>=0;i--){

            char c = nStr.charAt(i);

            if(c>=65){
                int num = c - 'A' + 10;
                sum += num*digit;
            }else{
                int num = c - '0';
                sum += num*digit;
            }
            
            digit = digit*b;
        }

        bw.write(sum+"");

        bw.flush();
        bw.close();
        br.close();

    }
}

/*

각 자리의 숫자마다 곱해야하는 수
1
1*b
1*b*b

0~9인 경우: 그대로 숫자 사용

A: 65
Z: 90
A~Z인 경우: 변환

문자 - '65' + 10


* */
