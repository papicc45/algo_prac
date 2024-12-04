package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        while (true) {
            char[] arr = br.readLine().toCharArray();
            if(arr[0] == '-')
                break;

            Stack<Character> stack = new Stack<>();
            int result = 0;

            for(int i=0 ; i<arr.length ; i++) {

                char temp = arr[i];

                if(temp == '{') {
                    stack.push(temp);
                } else {

                    if(stack.isEmpty()) {
                        result++;
                        stack.push('{');
                    } else if(stack.peek() == '{') {
                        stack.pop();
                    }
                }
            }
            System.out.println(num + ". " + (result + stack.size()/2));
            num++;
        }
    }
}
