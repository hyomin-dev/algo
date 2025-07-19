import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n+1];

        for(int i=1;i<=n;i++){
            int value = Integer.parseInt(st.nextToken());
            deque.offer(i);
            array[i] = value;

        }

        boolean right = true;
        int count = 0;
        int order=0;
        while(!deque.isEmpty()){

            int x;

            if (right){ // 시계 방향으로 돌고 있는 경우
                x = deque.pollFirst();
            }else{
                x = deque.pollLast();
            }

            if(deque.isEmpty()) {
                bw.write(String.valueOf(x));
                break;
            }

            if(x==1){ // 풍선을 처음 꺼낸 경우
                bw.write(x+" ");
                order = array[1];
                if(order>0)
                    right = true;
                else
                    right = false;
            }else{
                //카운트를 증가 시킨다.
                if(right)
                    count++;
                else
                    count--;

                if(count==order){ // 떠트려야할 경우
                    bw.write(x+" ");
                    order = array[x];
                    count = 0;
                    if(order>0)
                        right = true;
                    else
                        right = false;
                } else{
                    if(right)
                        deque.offerLast(x);
                    else
                        deque.offerFirst(x);
                }
            }

        }

        bw.flush();
        bw.close();
        br.close();

    }
}
