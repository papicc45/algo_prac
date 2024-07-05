package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2469 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        char[][] ladder = new char[n][k-1];
        char[] start = new char[k];

        for(int i=0 ; i<k ; i++)
            start[i] = (char)('A' + i);

        char[] end = br.readLine().toCharArray();

        int qline = 0;
        for(int i=0 ; i<n ; i++) {
            ladder[i] = br.readLine().toCharArray();
            if(ladder[i][0] == '?')
                qline = i;
        }

        for(int i=0 ; i<qline ; i++) {
            for(int j=0 ; j<k-1 ; j++) {
                if(ladder[i][j] == '-') {
                    char ch = start[j];
                    start[j] = start[j+1];
                    start[j+1] = ch;
                }
            }
        }

        for(int i=n-1 ; i>qline ; i--) {
            for(int j=0 ; j<k-1 ; j++) {
                if(ladder[i][j] == '-') {
                    char ch = end[j];
                    end[j] = end[j+1];
                    end[j+1] = ch;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<k-1 ; i++) {
            if(start[i] == end[i])
                sb.append("*");
            else if(start[i] == end[i+1] || start[i+1] == end[i]) {
                sb.append("-");
                char ch = start[i];
                start[i] = start[i+1];
                start[i+1] = ch;
            } else {
                break;
            }
        }

        if(sb.toString().length() != k-1) {
            for(int i=0 ; i<k-1 ; i++)
                System.out.print("x");

        } else {
            System.out.println(sb.toString());
        }
    }
}
