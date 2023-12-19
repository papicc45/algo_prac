package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pBook = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mBook = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0 ; i<n ; i++) {
            int book = Integer.parseInt(st.nextToken());
            if(book > 0)
                pBook.add(book);
            else {
                book = Math.abs(book);
                mBook.add(book);
            }
        }
        int result = 0;
        if(pBook.size() == 0) {
            System.out.println(rebaseBook(0, m, mBook));
            return;
        }

        if(mBook.size() == 0) {
            System.out.println(rebaseBook(0, m, pBook));
            return;
        }
        if(pBook.peek() >= mBook.peek()) {
            result += rebaseBook(0, m, pBook);
            result += rebaseBook(1, m, mBook);
        } else {
            result += rebaseBook(1, m, pBook);
            result += rebaseBook(0, m, mBook);
        }
        System.out.println(result);

    }
    static int rebaseBook(int x, int m, PriorityQueue<Integer> queue) {
        int result = 0;
        if(x == 1) {    //왕복
            while(!queue.isEmpty()) {
                int index = m;
                int temp = queue.peek();

                result = result + temp * 2;
                while(!queue.isEmpty() && index != 0) {
                    queue.poll();
                    index--;
                }
            }
        } else {    //왕복 x
            int last = queue.peek();
            result += last;
            int index = m;
            while(!queue.isEmpty() && index != 0) {
                queue.poll();
                index--;
            }
            if(!queue.isEmpty()) {
                while(!queue.isEmpty()) {
                    index = m;
                    int temp = queue.peek();

                    result = result + temp * 2;

                    while(!queue.isEmpty() && index != 0) {
                        queue.poll();
                        index--;
                    }
                }
            }
        }
        return result;
    }
}
