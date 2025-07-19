import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 1 <= N <= 100,000

        boolean[] isStack = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(st.nextToken().equals("1")){
                isStack[i] = true;
            }else
                isStack[i] = false;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
          if(!isStack[i])
              deque.offerFirst(Integer.parseInt(st.nextToken()));
          else {
              st.nextToken();
              continue;
          }
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            deque.offerLast(Integer.parseInt(st.nextToken()));
            int num = deque.pollFirst();
            bw.write(num+" ");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
