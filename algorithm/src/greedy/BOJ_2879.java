package greedy;

import kotlin.reflect.KType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2879 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] temp = new int[n];
        int[] correct = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            correct[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        int result = 0;
        while (index < n) {
            if(temp[index] > correct[index]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(index);
                for(int j=index+1 ; j<n ; j++) {
                    if(temp[j] > correct[j]) {
                        queue.add(j);
                    } else {
                        break;
                    }
                }
                while (!queue.isEmpty()) {
                    temp[queue.poll()]--;
                }
                result++;
            } else if(temp[index] < correct[index]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(index);
                for(int j=index+1 ; j<n ; j++) {
                    if(temp[j] < correct[j]) {
                        queue.add(j);
                    } else {
                        break;
                    }
                }
                while (!queue.isEmpty()) {
                    temp[queue.poll()]++;
                }
                result++;
            }

            if(temp[index] == correct[index]) {
                index++;
            }
        }
        System.out.println(result);
    }
}
