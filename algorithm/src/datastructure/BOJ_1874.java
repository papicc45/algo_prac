package datastructure;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int index = 1;
        boolean check = true;
        for(int i=0 ; i<n ; i++) {
            int temp = sc.nextInt();
            if(index <= temp) {
                while (index <= temp) {
                    stack.push(index++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int x = stack.pop();
                if(x > temp) {
                    System.out.println("NO");
                    check = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if(check)
            System.out.println(sb.toString());

    }
}
