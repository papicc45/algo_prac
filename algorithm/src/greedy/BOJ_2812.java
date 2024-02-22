package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.*;

public class BOJ_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = str.charAt(i) - '0';

            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && count < k) {
                    if (stack.peek() < num) {
                        stack.pop();
                        count++;
                    } else {
                        break;
                    }
                }
            }

            stack.push(num);

            if (count == k) {
                sb.append(str.substring(i+1));
                break;
            }
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (count < k) {
                count++;
                continue;
            }
            sb.insert(0, num);
        }

        System.out.println(sb);
        System.out.println(sb.toString());
    }
}
