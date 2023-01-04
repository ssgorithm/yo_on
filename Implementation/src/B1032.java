//백준 구현 Q1032 명령 프롬프트 (브론즈1)
//https://www.acmicpc.net/problem/1032

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1032{
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int commandCnt = Integer.parseInt(s);
        String[] command = new String[commandCnt];

        for(int i = 0; i < commandCnt; i++){
            command[i] = reader.readLine();
        }

        int len = command[0].length();
        StringBuilder sb = new StringBuilder();
        sb.append(command[0]);

        for(int i = 0; i < len; i++){
            for(int j = 0; j < commandCnt-1; j++){
                if(command[j].charAt(i) != command[j+1].charAt(i)){
                    sb.setCharAt(i, '?');
                    break;
                }
            }
        }
        System.out.print(sb.toString());
        reader.close();
    }
}
