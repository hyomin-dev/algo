import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 <= n,k <= 300,000
        int n = Integer.parseInt(st.nextToken()); // 보석의 개수
        int k = Integer.parseInt(st.nextToken()); // 가방의 개수

        PriorityQueue<Jewel1202> jewels = new PriorityQueue<>(); // 모든 보석을 담고 있고, 무게를 기준으로 오름차순
        PriorityQueue<JewelValue1202> jewelsValue = new PriorityQueue<>(); // i번째 가방이하의 보석들을 담고 있고, 가치를 기준으로 내림차순
        PriorityQueue<Integer> bag = new PriorityQueue<>(); // 모든 가방을 담고 있고, 무게를 기준으로 오름차순

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            jewels.offer(new Jewel1202(weight,value));
        }

        for(int i=0;i<k;i++){
            bag.offer(Integer.parseInt(br.readLine()));
        }

        long sum = 0;
        while(!bag.isEmpty()){
            int bagWeight = bag.poll();

            while(!jewels.isEmpty()){

                Jewel1202 now = jewels.poll();

                if(now.getWeight()>bagWeight){ // 꺼낸 보석의 무게가 가방의 무게보다 큰 경우
                    jewels.offer(now);
                    break;
                }else{ // 꺼낸 보석의 무게가 가방의 무게보다 작다면 가치를 기준으로 내림차순하는 우선순위 큐에 삽입
                    jewelsValue.offer(new JewelValue1202(now.getWeight(), now.getValue()));
                }
            }

            if(!jewelsValue.isEmpty())
                sum += jewelsValue.poll().getValue();

        }

        bw.write(sum+"");

        bw.flush();
        bw.close();
        br.close();

    }
}

class Jewel1202 implements Comparable<Jewel1202>{
    private int weight;
    private int value;

    public Jewel1202(int weight, int value){
        this.weight = weight;
        this.value = value;
    }

    public int getWeight(){
        return this.weight;
    }

    public int getValue(){
        return this.value;
    }

    // 무게를 기준으로 오름차순
    @Override
    public int compareTo(Jewel1202 o){

        return this.weight - o.weight;
    }
}

class JewelValue1202 implements Comparable<JewelValue1202> {
    private int weight;
    private int value;

    public JewelValue1202( int weight, int value){
        this.weight = weight;
        this.value = value;
    }

    public int getWeight () {
        return this.weight;
    }

    public int getValue () {
        return this.value;
    }

    // 무게를 기준으로 오름차순
    @Override
    public int compareTo (JewelValue1202 o){

        return o.value - this.value;
    }
}