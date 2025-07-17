import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // n일, 1<= n <= 100,000
        m = Integer.parseInt(st.nextToken()); // m번, 1<= m <=n

        array = new int[n+1];
        int totalBudget=0; // 10,000 X 10,000 = 1억
        int maxBudget = 0;
        for(int i=1;i<=n;i++) {
            array[i] = Integer.parseInt(br.readLine());
            totalBudget +=array[i];
            if(array[i]>maxBudget)
                maxBudget = array[i];
        }

        // 인출 횟수 < m --> k를 줄여야 됨
        // 인출 횟수 > m --> k를 늘려야 됨
        int minK = Integer.MAX_VALUE;
        int left = maxBudget;
        int right = totalBudget;

        while(left<=right){
            int mid = (left+right)/2;

            if(cal(mid)){
                if(minK>mid) {
                    minK = mid;
                }
                right = mid - 1;
            }else
                left = mid+1;

        }

        bw.write(String.valueOf(minK));
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean cal(int k){

        int currentBudget = 0;
        int count = 0;
        for(int i=1;i<=n;i++){
            if(currentBudget>=array[i]){  // 돈이 충분한 경우
                currentBudget -=array[i];
            }else{

                currentBudget = k-array[i];
                count++;
            }
        }

        if(count <= m) //count가 작다면, 억지로 맞출 수 있음
            return true;
        else
            return false;

    }

}

/*

k원 꺼낸 돈이 충분한 경우 --> 그대로 사용, 남은 금액은 그대로 가지고 있음
돈이 모자라는 경우 --> 남은 금액은 통장에 넣고 k원을 인출

M을 맞추기 위해 남은 금액이 그날 사용할 금액보다 많아도, 남은 금액은 통장에 집어 넣고 다시 k원을 인출할 수 있다.`
* */
