// 백준 구현 S14756 날짜계산 (실버5)
// https://www.acmicpc.net/problem/1476

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1476 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //E,S,M 입력 받기
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 1;
        while(true){
            //year-E가 15, 28, 19로 모두 나누어지는 경우 year가 답임
            if((year-E)%15 == 0 && (year-S)%28 == 0 && (year-M)%19 == 0) break;
            year++;
        }
        System.out.print(year);
    }
}
