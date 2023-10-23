package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            String str = br.readLine();

            StringBuilder sb = new StringBuilder(str).reverse();

            if(str.equals(sb.toString())) {
                System.out.println(0);
            } else {
                int start = 0;
                int end = str.length() - 1;
                boolean check = false;
                while(start < end) {
                    if(str.charAt(start) != str.charAt(end)) {
                        StringBuilder leftSB = new StringBuilder(str).deleteCharAt(start);
                        StringBuilder rightSB = new StringBuilder(str).deleteCharAt(end);

                        if(leftSB.toString().equals(leftSB.reverse().toString()) || rightSB.toString().equals(rightSB.reverse().toString())) {
                            System.out.println(1);
                            check = true;
                        }
                        break;
                    }
                    start++;
                    end--;
                }
                if(!check)
                    System.out.println(2);
            }
        }
    }
}
