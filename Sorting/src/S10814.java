//백준 정렬 Q10814 나이순 정렬 (실버5)
//https://www.acmicpc.net/problem/10814

import java.io.*;
import java.util.StringTokenizer;

public class S10814 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        StringBuilder[] ageSB = new StringBuilder[201];
        for(int i = 0; i < 201; i++){
            ageSB[i] = new StringBuilder("");
        }

        //StringBuilder 형식의 나이 배열을 만들어서 같은 나이라면, 자동으로 가입 순서대로 입력되도록 함
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            ageSB[age].append(age).append(" ").append(st.nextToken()).append("\n");
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder sbb : ageSB){
            sb.append(sbb);
        }
        System.out.print(sb);
    }
}
