//백준 투포인터 Q1253 좋다 (골드4)
// https://www.acmicpc.net/problem/1253

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1253 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;

        for(int i = 0; i < N; i++){
            int start = 0;
            int end = N - 1;
            int now = arr[i];

            while(start < end){
                int num = arr[start] + arr[end];
                if(num < now) start++;
                else if(num > now) end--;
                else{
                    if(i != start && i != end){
                        sum++;
                        break;
                    }
                    if(start == i) start++;
                    if(end == i) end--;
                }
            }
        }
        System.out.print(sum);
    }
}
