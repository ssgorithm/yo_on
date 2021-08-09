//백준 다이나믹 프로그래밍 G2225 합분해 (골드5)
//https://www.acmicpc.net/problem/2225

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2225 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K+1][N+1];

        for(int i = 0; i < N+1; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i < K+1; i++){
            dp[i][0] = 1;
        }

        for(int i = 2; i < K+1; i++){
            for(int j = 1; j < N+1; j++){
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
            }
        }

        System.out.print(dp[K][N]);
    }
}
