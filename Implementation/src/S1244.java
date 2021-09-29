//백준 구현 Q1244 스위치 켜고 끄기 (실버4)
//https://www.acmicpc.net/problem/1244

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1244 {
    //스위치 배열
    public static int[] switches;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //스위치 개수 입력받기
        int s = Integer.parseInt(br.readLine());
        switches = new int[s + 1];

        //스위치 상태 입력받기
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i = 1; i <= s; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }

        //학생 수 입력받기
        int student = Integer.parseInt(br.readLine());

        for(int i = 0; i < student; i++){
            st  = new StringTokenizer(br.readLine());
            int mf = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            //남자면
            if(mf == 1) {
                //num의 배수만큼 스위치 조절
                for(int j = 1; j < s/num + 1; j++){
                    swap(num*j);
                }
            }

            //여자면
            else{
                //현재 num의 바로 앞, 바로 뒤 인덱스 구하기
                int start = num - 1;
                int end = num + 1;

                while(true){
                    //start가 0이하거나 end가 s+1이상이면
                    //즉 start, end는 1~s 사이의 값이어야 함
                    if (start < 1 || end >= s + 1) break;
                    //같다면 그 다음도 대칭인지 확인
                    if(switches[start] == switches[end]){
                        start--;
                        end++;
                    }
                    //다르다면 끝
                    else break;
                }

                //현재 위치에선 대칭이 아니므로 start++, end--해줌
                start++;
                end--;

                //start부터 end까지 싹 다 바꿔줌
                for(int index = start; index < end+1; index++){
                    swap(index);
                }
            }
        }

        //20개 단위로 출력
        for (int j = 1; j < s + 1; j++) {
            System.out.print(switches[j] + " ");
            if (j % 20 == 0)
                System.out.println();
        }
    }

    //0,1 변경하는 함수
    //switches[num] ^= 1로 하면 더 간단함
    public static void swap(int num){
        if(switches[num] == 1) switches[num] = 0;
        else switches[num] = 1;
    }
}

