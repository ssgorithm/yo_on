//백준 문자열 Q9012 괄호 (실버4)
//https://www.acmicpc.net/problem/9012

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S9012 {
    public static void main(String args[]) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int commandNum = Integer.parseInt(reader.readLine());
        int count = 0, j = 0;

        for(int i = 0; i < commandNum; i++){
            char arr[] = reader.readLine().toCharArray();
            for(j = 0; j < arr.length; j++){
                count = arr[j] == '(' ? count + 1 : count - 1;

                if(count < 0){
                    sb.append("NO\n");
                    break;
                }

            }
            if(j == arr.length){
                if (count == 0) sb.append("YES\n");
                else sb.append("NO\n");
            }
            count = 0;
        }

        System.out.print(sb);

    }
}
