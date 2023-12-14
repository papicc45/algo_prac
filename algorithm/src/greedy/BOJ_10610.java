package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.next().split("");

        boolean checkZero = false;
        int sum = 0;
        int[] intArr = new int[arr.length];
        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i].equals("0")) {
                checkZero = true;
            }
            intArr[i] = Integer.parseInt(arr[i]);
            sum += Integer.parseInt(arr[i]);
        }

        if(checkZero) {
            if(sum % 3 == 0) {
                Arrays.sort(intArr);

                for(int i=intArr.length-1 ; i>=0 ; i--) {
                    System.out.print(intArr[i]);
                }
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(-1);
        }
    }
}
