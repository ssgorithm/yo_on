//백준 문자열 Q2941 크로아티아 알파벳 (실버5)
//https://www.acmicpc.net/problem/2941

import java.io.*;

public class S2941 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] words = br.readLine().toCharArray();
        int size = words.length;
        int count = 0;
        for(int i = 0; i < size; i++){
            char word = words[i];
            if(word == 'c' && i < size - 1){
                if(words[i+1] == '=' || words[i+1] == '-'){
                    i++;
                }
            }
            else if(word == 'd' && i < size - 1){
                if(words[i+1] == 'z' && i < size - 2){
                    if(words[i+2] == '=') {
                        i += 2;
                    }
                }else if(words[i+1] == '-'){
                    i++;
                }
            }
            else if((word == 'l' || word == 'n') && i  < size - 1){
                if(words[i+1] == 'j') {
                    i++;
                }
            }
            else if((word == 's' || word=='z') && i < size - 1){
                if(words[i+1] == '='){
                    i++;
                }
            }
            count++;
        }
        System.out.print(count);
    }
}