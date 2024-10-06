package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1132 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Alphabet[] alphabets = new Alphabet[10];
        for(int i=0 ; i<10 ; i++)
            alphabets[i] = new Alphabet();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j=0 ; j<str.length() ; j++) {
                int number = str.charAt(j) - 'A';
                if(j == 0)
                    alphabets[number].first = true;

                alphabets[number].num += Math.pow(10, str.length() - j - 1);
            }
        }

        Arrays.sort(alphabets);
        boolean[] visited = new boolean[10];
        long sum = 0;

        for(int i=0 ; i<10 ; i++) {
            if(alphabets[i].first) {
                for(int j=1 ; j<10 ; j++) {
                    if(!visited[j]) {
                        visited[j] = true;
                        sum += alphabets[i].num * (long)j;
                        break;
                    }
                }
            } else {
                for(int j=0 ; j<10 ; j++) {
                    if(!visited[j]) {
                        visited[j] = true;
                        sum += alphabets[i].num * (long)j;
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
    static class Alphabet implements Comparable<Alphabet> {
        long num = 0;
        boolean first = false;

        @Override
        public int compareTo(Alphabet o) {
            if(o.num < this.num) return 1;
            else if(this.num == o.num) return 0;
            else return -1;
        }
    }
}
