//백준 구현 Q2108 통계학 (실버4)
//https://www.acmicpc.net/problem/2108

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2108 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static int[] array;
    static int N;

    public static void main(String args[]) throws IOException {
        N = Integer.parseInt(br.readLine());
        //-4000 ~ 4000까지의 수
        array = new int[8001];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int med = 5000;
        int mode = 5000;

        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());
            sum += value;
            array[value + 4000]++;
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        int count = 0;
        int mode_max = 0;
        boolean flag = false;

        for(int i = min + 4000; i <= max + 4000; i++){
            if(array[i] > 0) {

                //중앙값 찾기
                if(count < (N + 1) / 2) {
                    count += array[i];	// i값의 빈도수를 count 에 누적
                    med = i - 4000;
                }

                 //최빈값 찾기
                 //이전 최빈값보다 현재 값의 빈도수가 더 높을 경우
                if(mode_max < array[i]) {
                    mode_max = array[i];
                    mode = i - 4000;
                    // 첫 등장이므로 true 로 변경
                    flag = true;
                }
                // 이전 최빈값 최댓값과 동일한 경우면서 한 번만 중복되는 경우
                else if(mode_max == array[i] && flag == true) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        System.out.println((int)Math.round((double)sum / N));
        System.out.println(med);
        System.out.println(mode);
        System.out.print(max-min);
    }


}
