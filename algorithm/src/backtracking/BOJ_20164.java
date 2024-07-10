package backtracking;

import java.util.Scanner;

public class BOJ_20164 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();
        recur(n, 0);

        System.out.println(min + " " + max);
    }
    private static void recur(String num, int odds) {
        int getOdd = getOdd(num);
        odds += getOdd;
        if(num.length() == 1) {
            max = Math.max(odds, max);
            min = Math.min(odds, min);
            return;
        }

        if(num.length() == 2) {
            int newNum = (num.charAt(0) - '0') + num.charAt(1) - '0';
            recur(String.valueOf(newNum), odds);
        } else {
            for(int i=0 ; i<num.length()-2 ; i++) {
                for(int j=i+1 ; j<num.length()-1 ; j++) {
                    String s1 = num.substring(0, i+1);
                    String s2 = num.substring(i+1, j+1);
                    String s3 = num.substring(j+1, num.length());

                    int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                    recur(String.valueOf(sum), odds);
                }
            }
        }
    }
    private static int getOdd(String num) {
        int result = 0;
        for(int i=0 ; i<num.length() ; i++) {
            if((num.charAt(i) - '0') % 2 == 1) {
                result++;
            }
        }
        return result;
    }
}
