//백준 정렬 Q2217 로프 (실버4)
//https://www.acmicpc.net/problem/2217

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2217 {
    public static void main(String agrs[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];

        for(int i = 0; i < n; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);
        int max = 0;

        for(int i = 0; i < n; i++){
            if(rope[i] * (n-i) > max) max = rope[i] * (n-i);
        }

        System.out.print(max);
    }
}
