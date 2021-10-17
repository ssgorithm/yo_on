//백준 다이나믹 프로그래밍 Q1697 숨바꼭질 (실버1)
//https://www.acmicpc.net/problem/1697

import java.io.*;
import java.util.*;

public class S1697 {
    public static int n, k;
    public static int[] dp;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k) System.out.print(0);
        else{
            dp = new int[Math.max(n,k)+10];
            dp[n] = 0;
            // dp 초기화, +1만 했을 경우로
            for(int i = n-1; i >= 0; i--){
                dp[i] = dp[i+1] + 1;
            }
            solve();
            System.out.print(dp[k]);
        }
    }

    public static void solve(){
        for(int i = n+1; i <= k+9; i++){
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i/2]+1, dp[i-1]+1);
            }else{
                dp[i] = Math.min(dp[i/2]+2, dp[i-1]+1);
            }
            dp[i-1] = Math.min(dp[i]+1, dp[i-1]);
        }
    }
}