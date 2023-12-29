package math;

import java.awt.*;
import java.time.format.TextStyle;
import java.util.Scanner;

public class BOJ_1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long min = sc.nextLong();
        long max = sc.nextLong();

        int result = 0;

        //최댓값, 최솟값 차이만큼
        boolean[] check = new boolean[(int) (max - min) + 1];

        //2 제곱수부터 max보다 작거나 같을때까지
        for(long i=2 ; i*i <= max ; i++) {
            long pow = i * i;
            long index = min / pow;

            //나머지 있으면 1해 min보다 큰 제곱수 시작
            if(min % pow != 0)
                index++;
            for(long j=index ; pow*j <= max ; j++) {
                check[(int) ((pow * j) - min)] = true;
            }
        }

        for(int i=0 ; i<=max - min ; i++) {
            if(!check[i])
                result++;
        }
        System.out.println(result);

    }
}
