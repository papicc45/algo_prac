package dynamicprogramming;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PRO_N으로_표현 {
    static ArrayList<HashSet<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int number = sc.nextInt();

        System.out.println(solution(N, number));
    }
    public static int solution(int N, int number) {

        for(int i=0 ; i<=8 ; i++) {
            list.add(new HashSet<>());
        }

        //숫자를 1개만 썼을 때
        list.get(1).add(N);

        //숫자를 2개만 썼을 때
        list.get(2).add(N * 10 + N);
        list.get(2).add(N + N);
        list.get(2).add(N / N);
        list.get(2).add(N * N);

        //숫자를 3개이상 썼을 때
        for(int i=3 ; i<=8 ; i++) {
            for(int j=1 ; j<i ; j++) {
                makeN(i, j, N);
            }
        }

        for(int i=1 ; i<=8 ; i++) {
            HashSet<Integer> set = list.get(i);
            if(set.contains(number)) {
                return i;
            }
        }
        return -1;
    }
    static void makeN(int i, int j, int number) {
        StringBuilder sb = new StringBuilder();
        for(int k=0 ; k<i ; k++) {
            sb.append(number);
        }
        list.get(i).add(Integer.parseInt(sb.toString()));

        for(Integer num1 : list.get(i-j)) {
            for(Integer num2 : list.get(j)) {
                list.get(i).add(num1 + num2);
                if(num1 - num2 > 0)
                    list.get(i).add(num1 - num2);
                list.get(i).add(num1 * num2);
                if(num1 / num2 > 0)
                    list.get(i).add(num1 / num2);
            }
        }

    }
}
