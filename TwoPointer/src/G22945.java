//백준 투포인터 Q22945 팀 빌딩 (골드5)
// https://www.acmicpc.net/problem/22945

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G22945 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N - 1;
        int max = -1;

        //사이의 수가 가장 많은 경우부터 탐색
        // 가리키는 수가 더 작은 것의 위치를 이동
        while(start != end){
            int num = (end-start-1) * Math.min(arr[start], arr[end]);
            max = Math.max(max, num);
            if(arr[start] < arr[end]) start++;
            else end--;
        }

        System.out.print(max);
    }
}
