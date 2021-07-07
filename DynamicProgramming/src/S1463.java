//백준 다이나믹 프로그래밍 Q1463 1로 만들기 (실버3)
//https://www.acmicpc.net/problem/1463

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1463 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for(int i = 2; i <= N; i++){
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0 && dp[i] > dp[i/2] + 1) dp[i] = dp[i/2] + 1;
            if(i % 3 == 0 && dp[i] > dp[i/3] + 1) dp[i] = dp[i/3] + 1;
        }

        System.out.print(dp[N]);
    }
}