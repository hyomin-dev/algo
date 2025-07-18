import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 현재 가로수의 수, 3 <= n <= 100,000
        int before = 0;
        int first = 0;
        int end = 0;
        for(int i=0;i<n;i++){
            int input = Integer.parseInt(br.readLine());

            if(before==0) {
                before = input;
                first = input;
            }
            else{
                set.add(input-before);
                before = input;
            }
            if(i==n-1)
                end = input;
        }
        
        if(set.size()==1){
            bw.write("0");
        }else{
            Iterator<Integer> itorator = set.iterator();
            int gcd = 1;
            if(itorator.hasNext()){
                int prev = itorator.next();
                while(itorator.hasNext()){
                    int curr = itorator.next();

                    gcd = euclid(Math.max(prev,curr),Math.min(prev,curr));

                    prev = gcd;
                }
            }

            int totalNum = (end-first)/gcd +1;
            int extraNum = totalNum - n;

            bw.write(String.valueOf(extraNum));
        }


       bw.flush();
       bw.close();
       br.close();

    }

    static int euclid(int a, int b){
        if(b==0)
            return a;
        return euclid(b, a%b);
    }
}
