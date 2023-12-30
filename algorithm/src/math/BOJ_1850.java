package math;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_1850 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        long gcd = gcd(a, b);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(gcd > 0) {
            bw.write("1");
            gcd--;
        }
        bw.flush();
        bw.close();
    }
    private static long gcd(long a, long b) {
        if(b == 0)
            return a;

        return gcd(b, a % b);
    }
}
