package bruteforce;

import java.util.Scanner;

public class BOJ_1254 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int idx = 0;
        while (true) {
            if(isPalindrome(str.substring(idx, str.length()))) {
               break;
            }

            idx++;
        }

        System.out.println(str.length() + idx);
    }
    private static boolean isPalindrome(String str) {
        for(int i=0 ; i<str.length()/2 ; i++) {
            if(str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }

        return true;
    }
}
