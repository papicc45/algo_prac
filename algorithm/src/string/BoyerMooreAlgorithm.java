package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BoyerMooreAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String pattern = sc.nextLine();

        System.out.println(match(text, pattern));
    }
    private static int match(String text, String pattern) {
        int textPointer;
        int patternPoitner;
        int textLen = text.length();
        int patternLen = pattern.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        //건너뛰기 표 만들기
        for(textPointer=0 ; textPointer<=Character.MAX_VALUE ; textPointer++) {
            skip[textPointer] = patternLen;
        }
        for(textPointer=0 ; textPointer<patternLen-1 ; textPointer++) {
            skip[pattern.charAt(textPointer)] = patternLen - textPointer - 1;
        }

        //검색
        while(textPointer < textLen) {
            patternPoitner = patternLen - 1;    //패턴 끝 문자

            //패턴 끝부터 텍스트포인터 끝부터 앞의 패턴길이까지 비교
            while(text.charAt(textPointer) == pattern.charAt(patternPoitner)) {
                if(patternPoitner == 0)
                    return textPointer;

                patternPoitner--;
                textPointer--;
            }

            //패턴이 들어있는 문자열을 만날 경우, 마지막에 나오는 skip[문자]만큼 패턴 포인터를 옮김
            //들어있지 않다면 패턴 길이만큼 패턴 포인터를 옮김
            if(skip[text.charAt(patternPoitner)] > patternLen - patternPoitner) {
                textPointer += skip[text.charAt(textPointer)];
            } else {
                textPointer += patternLen - patternPoitner;
            }
        }
        return -1;
    }
}
