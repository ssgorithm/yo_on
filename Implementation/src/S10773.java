//백준 구현 Q10773 제로 (실버4)
//https://www.acmicpc.net/problem/10773

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class S10773 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int index = 0;
        int sum = 0;

        //차례로 수 입력받기
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            //0이면 index--
            //제일 마지막에 입력받은 수 없애기
            if(num == 0){
                index--;
            }
            //0 아니면 입력
            else{
                stack[index++] = num;
            }
        }
        br.close();

        //잘못 쓰이지 않은 수들의 합
        for(int i = 0; i < index; i++){
            sum += stack[i];
        }

        System.out.print(sum);
    }
}
