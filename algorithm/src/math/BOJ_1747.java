package math;

import java.util.Scanner;

public class BOJ_1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[10000001];

        for(int i=2 ; i<10000001 ; i++) {
            arr[i] = i;
        }

        for(int i=2 ; i<Math.sqrt(10000001) ; i++) {
            if(arr[i] == 0)
                continue;

            for(int j=i+i ; j<arr.length ; j+=i) {
                arr[j] = 0;
            }
        }

        for(int i=n ; i<10000001 ; i++) {
            if(arr[i] != 0) {
                if(isPalindrome(i)) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
    public static boolean isPalindrome(int num) {
        char[] arr = String.valueOf(num).toCharArray();

        for(int i=0 ; i<arr.length/2 ; i++) {
            if(arr[i] != arr[arr.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
