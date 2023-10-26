package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> mainStack = new Stack<>();
        Stack<Character> leftMoveStack = new Stack<>();
        for(int i=0 ; i<str.length() ; i++) {
            char ch = str.charAt(i);
            mainStack.push(ch);
        }
        int n = Integer.parseInt(br.readLine());

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String edit = st.nextToken();
            switch (edit) {
                case  "P":
                    mainStack.push(st.nextToken().charAt(0));
                    break;
                case "L":
                    if(!mainStack.isEmpty()) {
                        leftMoveStack.push(mainStack.pop());
                    }
                    break;
                case "B":
                    if(!mainStack.isEmpty()) {
                        mainStack.pop();
                    }
                    break;
                case "D":
                    if(!leftMoveStack.isEmpty()) {
                        mainStack.push(leftMoveStack.pop());
                    }
                    break;
                default:
                    break;
            }
        }
        if(!leftMoveStack.isEmpty()) {
            while (!leftMoveStack.isEmpty()) {
                mainStack.push(leftMoveStack.pop());
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!mainStack.isEmpty()) {
            sb.append(mainStack.pop());
        }

        System.out.println(sb.reverse().toString());
    }
}
