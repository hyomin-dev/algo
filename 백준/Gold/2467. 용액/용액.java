import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 2 <= n <= 100,000
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(array);
        if(array[0]>=1){
            bw.write(array[0]+" "+array[1]);
        }else if(array[n-1]<=-1){
            bw.write(array[n-2]+" "+array[n-1]);
        }else{
            int minValue = Integer.MAX_VALUE;

            int end = n-1;
            ArrayList<int[]> list = new ArrayList<>();

            // array[start] + array[end] > 0 --> end를 줄여서 0에 가까워지도록

            // array[start] + array[end] <0 --> start를 키워서 0에 가까워지도록

            for(int start=0;start<n-1;start++){
                if(start>=end)
                    break;

                int sum = array[start] + array[end];
                int sumAbs = Math.abs(sum);
                if(sum==0){ // start를 갱신
                    minValue = 0;
                    list = new ArrayList<>();
                    list.add(new int[]{array[start], array[end]});
                    break;
                }
                if(sumAbs <=minValue) { // start를 갱신했을 때 체크
                    minValue = sumAbs;
                    list = new ArrayList<>();
                    list.add(new int[]{array[start], array[end]});
                }

                // Math.abs

                while(sum>0){

                    end--;
                    if(start>=end){
                        end++; // 감소 시킨 것 취소 후
                        break;
                    }
                    sum = array[start] + array[end];
                    if(sum==0){ // end를 갱신 후 확인
                        minValue = 0;
                        list = new ArrayList<>();
                        list.add(new int[]{array[start], array[end]});
                        break;
                    }

                    sumAbs = Math.abs(sum);

                    if(sumAbs <=minValue) { // end를 갱신했을 때 체크
                        minValue = sumAbs;
                        list = new ArrayList<>();
                        list.add(new int[]{array[start], array[end]});
                    }
                }
                if(sum==0)
                    break;

            }

            if(minValue!=Integer.MAX_VALUE){
                int[] result = list.get(0);
                bw.write(result[0]+" "+result[1]);
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

/*
서로 다른 두 용액을 혼합

산성 용액만 또는 알칼리성 용액만 섞어도 됨

두 용액의 특성은 오름차순으로 출력

0이 없으면 0에 가까운 특성값이 출력되도록

array[start] + array[end] > 0 --> end를 줄여서 0에 가까워지도록

array[start] + array[end] <0 --> start를 키워서 0에 가까워지도록

* */


