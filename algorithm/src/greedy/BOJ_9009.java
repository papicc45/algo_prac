package greedy;

import java.util.*;

public class BOJ_9009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int k=0 ; k<t ; k++) {
            int num = sc.nextInt();
            ArrayList<Long> list = new ArrayList<>();

            while(num != 0) {
                Queue<Long> queue = new LinkedList<>();

                queue.add(0L);
                queue.add(1L);
                long last = 0;
                while(true) {
                    long num1 = queue.poll();
                    long num2 = queue.poll();
                    if(num2 > num) {
                        last = num1;
                        break;
                    }
                    queue.add(num2);
                    queue.add(num2 + num1);
                }
                num -= last;
                list.add(last);
            }
            Collections.sort(list);
            for(Long i : list) {
                System.out.print(i + " ");
            }
        }
    }
}
