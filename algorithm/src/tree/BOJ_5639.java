package tree;

import javax.swing.text.DefaultStyledDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String next;
        while(true) {
            next = br.readLine();
            if(next == null || next.equals(""))
                break;

            root.insert(Integer.parseInt(next));
        }
        answer(root);
    }
    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }
        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void insert(int num) {
            if(num < this.num) {
                if(this.left == null)
                    this.left = new Node(num);
                else
                    this.left.insert(num);
            } else {
                if(this.right == null)
                    this.right = new Node(num);
                else
                    this.right.insert(num);
            }
        }
    }
    static void answer(Node node) {
        if(node == null)
            return;

        answer(node.left);
        answer(node.right);
        System.out.println(node.num);
    }
}
