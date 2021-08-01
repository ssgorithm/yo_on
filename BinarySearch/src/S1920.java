//백준 이분 탐색 Q1920 수 찾기 (실버4)
//https://www.acmicpc.net/problem/1920

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String args[]) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            sb.append(Arrays.binarySearch(A,Integer.parseInt(st.nextToken())) < 0 ? 0 : 1).append('\n');
        }

        System.out.print(sb.toString());
    }
}
