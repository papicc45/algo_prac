package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891 {
    static int[] arr = new int[26];
    static int countA;
    static int countC;
    static int countG;
    static int countT;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());
        countA = Integer.parseInt(st.nextToken());
        countC = Integer.parseInt(st.nextToken());
        countG = Integer.parseInt(st.nextToken());
        countT = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = m-1;
        int result = 0;
        for(int i=0 ; i<=end ; i++) {
            char ch = dna.charAt(i);
            count(ch, true);

            if(check()){
                result++;
            }
        }
        while(++end < n) {
            char front = dna.charAt(start++);
            count(front, false);
            char back = dna.charAt(end);
            count(back, true);

            if(check()) {
                result++;
            }

        }
        System.out.println(result);
    }
    public static void count(char ch, boolean pl) {
        if(pl) {
            arr[ch - 'A']++;
        } else {
            arr[ch - 'A']--;
        }
    }
    public static boolean check() {
        if(arr[0] >= countA && arr['C' - 'A'] >= countC && arr['G' - 'A'] >= countG && arr['T' - 'A'] >= countT)
            return true;
        else
            return false;
    }
}
