//백준 문자열 Q5582 공통 부분 문자열 (골드5)
//https://www.acmicpc.net/problem/5582

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5582 {
     public static void main(String args[]) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String s = br.readLine();
         String t = br.readLine();
         int slen = s.length();
         int tlen = t.length();

         int[][] lcs = new int[slen+1][tlen+1];
         int max = 0;

         for(int i = 1; i <= slen; i++){
             for(int j = 1; j <= tlen; j++){
                 if(s.charAt(i-1) == t.charAt(j-1)){
                     //문자가 같다면 대각선 위 + 1
                     lcs[i][j] = lcs[i - 1][j - 1] + 1;
                     //max값 갱신
                     max = Math.max(lcs[i][j], max);
                 }
             }
         }

         System.out.print(max);
     }
}
