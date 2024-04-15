package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<Integer> stack = new Stack<>();
            for(int i=0 ; i<n ; i++) {
                stack.push(Integer.parseInt(st.nextToken()));
            }

            long result = 0;
            int max = Integer.MIN_VALUE;
            while (!stack.isEmpty()) {
                int temp = stack.pop();
                if(max < temp) {
                    max = temp;

                } else {
                    result = result + (max - temp);
                }
            }
            System.out.println(result);
        }
    }
}
