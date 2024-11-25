package greedy;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_2374 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        long result = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            max = Math.max(max, a);

            if(stack.isEmpty()) {
                stack.push(a);
            } else {
                if(stack.peek() > a) {
                    stack.pop();
                    stack.push(a);
                } else if(stack.peek() < a) {
                    result += a - stack.pop();
                    stack.push(a);
                }
            }

        }

        while (!stack.isEmpty()) {
            result += max - stack.pop();
        }
        System.out.println(result);
    }
}
