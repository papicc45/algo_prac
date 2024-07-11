package implement;

import java.util.*;

public class BOJ_1302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            String book = sc.next();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        List<Book> list = new ArrayList<>();
        for(String key : map.keySet()) {
            list.add(new Book(key, map.get(key)));
        }

        Collections.sort(list);
        System.out.println(list.get(0).name);

    }
    static class Book implements Comparable<Book> {
        String name;
        int count;

        public Book(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Book o) {
            if(this.count == o.count) {
                return this.name.compareTo(o.name);
            } else {
                return o.count - this.count;
            }
        }
    }
}
