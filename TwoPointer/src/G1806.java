//백준 투포인터 Q1806 부분합 (골드4)
// https://www.acmicpc.net/problem/1806

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1806 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 1;
        int sum = 0, length = Integer.MAX_VALUE;

        while(true){
            //합이 크면 시작포인터에서 줄이기 시작
            if(sum >= S){
                sum -= arr[start];
                length = Math.min(length, end-start);
                start++;
            }
            //끝포인터가 배열 끝에 도착하면 break
            else if(end == N){
                break;
            }
            //합을 구하기 위해 끝포인터 더하기
            else{
                sum += arr[end];
                end++;
            }

        }
        System.out.print(length == Integer.MAX_VALUE ? 0 : length);
    }
}
