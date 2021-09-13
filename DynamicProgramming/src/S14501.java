// 백준 다이나믹 프로그래밍 Q14501 퇴사 (실버4)
// https://www.acmicpc.net/problem/14501

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S14501 {
    public static int n;
    public static int[] T, P, dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n 입력 받기
        n = Integer.parseInt(br.readLine());

        T = new int[n];
        P = new int[n];
        dp = new int[n+1];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n-1; i >= 0; i--){
            int time = T[i] + i;
            if(time <= n){
                dp[i] = Math.max(P[i]+dp[time], dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }
        }
        System.out.print(dp[0]);
    }
}