
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int prev = 0;

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n+1];
        for(int i=1;i<=n;i++)
            array[i] = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();

        for(int i=1;i<=n;i++){

            int x = array[i];

            if(prev<x){
                for(int j=prev+1;j<=x;j++) {
                    stack.push(j);
                    prev++;
                    list.add("+");
                }
            } // else: prev>=x

            if(!stack.isEmpty()&&stack.peek()==x) {

                stack.pop();
                list.add("-");
            }else if(!stack.isEmpty()&&stack.peek()!=x)
                break;
        }

        if(stack.isEmpty()){
            for(String oper: list)
                bw.write(oper+"\n");
        }else
            bw.write("NO");

        bw.flush();
        bw.close();
        br.close();
    }
}
/*

prev: stack에 넣은 것 까지의 수를 기록하는 변수
stack에 없다면: 자기 자신까지 stack에 넣는다 --> prev+1 ~ 자기 자신까지

stack 상단과 자기 자신이 같다면 pop
* */