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
        //정수의 개수 N 입력받기
        int n = Integer.parseInt(br.readLine());
        //크기가 N인 A배열 생성
        int[] A = new int[n];
        //A에 정수 입력받기
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        //A 배열 정렬
        Arrays.sort(A);

        //찾을 정수의 개수 M 입력받기
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        //각각의 수를 이분탐색하여 음수가 나오면(존재하지 않으면) 0, 그렇지 않으면(존재하면) 1을 StringBuilder sb에 저장
        for(int i = 0; i < m; i++){
            sb.append(Arrays.binarySearch(A,Integer.parseInt(st.nextToken())) < 0 ? 0 : 1).append('\n');
        }

        System.out.print(sb.toString());
    }
}
