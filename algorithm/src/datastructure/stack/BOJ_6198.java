package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long result = 0;
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0 ; i<n ; i++) {
            int h = Integer.parseInt(br.readLine());

            while (!stack.isEmpty()) {

                if(stack.peek() <= h) {
                    stack.pop();
                } else {
                    break;
                }
            }
            result += stack.size();
            stack.push(h);
        }

        System.out.println(result);

    }
}
