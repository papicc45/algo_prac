package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean check = false;
        for(int i=0 ; i<str.length() ; i++) {
            char temp = str.charAt(i);
            if(temp == '<') {
                check = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(temp);
            } else if (temp == '>') {
                check = false;
                sb.append(temp);
            } else if(check) {
                sb.append(temp);
            } else if(!check) {
                if(temp == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(temp);
                } else {
                    stack.push(temp);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
