//백준 정렬 Q5800 성적통계 (실버5)
//https://www.acmicpc.net/problem/5800

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5800 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] array = new int[N];
            int max = 0;

            for(int j = 0; j < N; j++){
                array[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(array);

            for(int j = 1; j < N; j++){
                max = Math.max(max, array[j]-array[j-1]);
            }

            sb.append("Class " + (i+1)).append("\n");
            sb.append("Max " + array[N-1] + ", Min " + array[0] + ", Largest gap " + max).append("\n");

        }

        System.out.print(sb.toString());
    }
}
