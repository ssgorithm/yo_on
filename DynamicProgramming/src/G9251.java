//백준 다이나믹 프로그래밍 G9251 LCS (골드5)
//https://www.acmicpc.net/problem/9251

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G9251 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        //첫번째 문자열 입력받기
        char[] one = br.readLine().toCharArray();
        //두번째 문자열 입력받기
        char[] two = br.readLine().toCharArray();
        //각 문자열 크기 구하기
        int oneSize = one.length;
        int twoSize = two.length;
        //배열 생성
        int[][] lcs = new int[oneSize + 1][twoSize + 1];

        //lcs 알고리즘
        //비교 문자가 같으면 대각선 위 + 1, 다르면 왼쪽과 위쪽 값 중 큰 것 선택
        for(int i = 1; i <= oneSize; i++){
            for(int j = 1; j <= twoSize; j++){
                if(one[i - 1] == two[j - 1]) lcs[i][j] = lcs[i-1][j-1] + 1;
                else lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }

        //결과값 출력
        System.out.print(lcs[oneSize][twoSize]);
    }
}
