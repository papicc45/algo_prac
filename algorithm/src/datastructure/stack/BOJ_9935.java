package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
    static Stack<Character> checkStack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String bomb = br.readLine();
        char lastChar = bomb.charAt(bomb.length() - 1);
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<str.length() ; i++) {
            char ch = str.charAt(i);
            stack.push(ch);
            checkStack.push(ch);

            if(checkStack.size() >= bomb.length() && ch == lastChar) {
                if(checkBomb(bomb)) {
                    //true
                    for(int j=0 ; j<bomb.length() ; j++) {
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse().toString());
    }
    static boolean checkBomb(String bomb) {
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<bomb.length() ; i++) {
            sb.append(checkStack.pop());
        }
        String pop = sb.reverse().toString();

        if(pop.equals(bomb)) {
            return true;
        } else {
            for(int i=0 ; i<pop.length() ; i++) {
                checkStack.push(pop.charAt(i));
            }
            return false;
        }
    }
}
