//백준 투포인터 Q2470 두 용액 (골드5)
// https://www.acmicpc.net/problem/2470

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2470 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] l = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            l[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(l);

        int start = 0;
        int end = N-1;
        int min = (int) 10e9;

        int num1 = 0;
        int num2 = 0;

        while(start < end){
            int val = l[start] + l[end];

            //용액 합의 최소
            if(min > Math.abs(val)){
                min = Math.abs(val);
                num1 = l[start];
                num2 = l[end];

                //0이면 종료
                if(val == 0) break;
            }

            if(val > 0) end--;
            else if(val < 0) start++;
        }

        System.out.print(num1 + " " + num2);
    }
}
