//백준 투포인터 Q2230 수 고르기 (골드5)
// https://www.acmicpc.net/problem/2230

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2230 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        //두 수를 고를 때 같은 수를 고를 수 있으므로 0,0으로 설정
        int end = 0, start = 0;
        //처음에 습관처럼 (int)1e9;로 했다가 틀림 -> 차이가 더 클 수 있기 때문
        int ans = Integer.MAX_VALUE;

        while (end < N) {
            if (arr[end] - arr[start] < M) {
                end++;
                continue;
            }

            if (arr[end] - arr[start] == M) {
                ans = M;
                break;
            }

            ans = Math.min(ans, arr[end] - arr[start]);
            start++;
        }

        System.out.print(ans);
    }
}
