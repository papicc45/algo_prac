package slidingwindow;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new LinkedList<>();

        for(int i=0 ; i<n ; i++) {
            Node node = new Node(i+1, Integer.parseInt(st.nextToken()));

            while(!deque.isEmpty() && deque.getLast().value > node.value) {
                deque.removeLast();
            }
            deque.addLast(node);

            if(deque.getFirst().index <= (i+1) - m) {
                deque.removeFirst();
            }

            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
}

class Node {
    int index;
    int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
