package greedy;

import java.util.Scanner;

public class BOJ_2195 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start = sc.nextLine();
        String end = sc.nextLine();

        int left = 0;
        int right = 1;
        int result = 0;
        while(right <= end.length()) {
            while(right <= end.length() && start.contains(end.substring(left, right))) {
                right++;
            }
            result++;
            left = right - 1;
        }
        System.out.println(result);
    }
}
