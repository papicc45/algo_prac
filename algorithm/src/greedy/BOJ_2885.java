package greedy;

import java.util.Scanner;

public class BOJ_2885 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int check = n;
        int min = 1;
        while(min < n) {
            min *= 2;
        }
        int total = min;
        System.out.print(total + " ");
        if(total == n) {
            System.out.print(0);
        } else {
            int cnt = 0;
            while (check != 0) {
                total /= 2;
                cnt++;
                if(check / total == 1) {
                    check -= total;
                }
            }
            System.out.print(cnt);
        }
    }
}
