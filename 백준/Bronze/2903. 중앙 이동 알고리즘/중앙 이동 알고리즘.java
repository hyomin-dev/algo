import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] array = new int[16];

        array[0] = 2;

        for(int i=1;i<=15;i++){
            array[i] = array[i-1]+array[i-1]-1;
        }

        int n = Integer.parseInt(br.readLine());

        bw.write(array[n]*array[n]+"");

        bw.flush();
        bw.close();
        br.close();

    }
}

/*
0 -> 4
1 -> 4+5
2 ->


* */
