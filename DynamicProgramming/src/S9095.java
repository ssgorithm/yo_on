// 백준 다이나믹 프로그래밍 Q9095 1,2,3 더하기 (실버3)
// https://www.acmicpc.net/problem/9095

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S9095 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] n = new int[T];
        int max = 0;

        for(int i = 0; i < T; i++){
            n[i] = Integer.parseInt(br.readLine());
            if(max < n[i]) max = n[i];
        }

        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < max + 1; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int i : n){
            System.out.println(dp[i]);
        }

    }
}
