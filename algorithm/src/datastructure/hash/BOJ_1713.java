package datastructure.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Student> list = new ArrayList<>();

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<k ; i++) {
            int num = Integer.parseInt(st.nextToken());

            boolean check = false;
            for(int j=0 ; j<list.size() ; j++) {
                Student student = list.get(j);
                if(student.num == num) {
                    check = true;
                    list.remove(j);
                    list.add(new Student(student.num, student.time, student.recommend + 1));
                    break;
                }
            }

            if(!check) {
                if(list.size() < n) {
                    list.add(new Student(num, i, 1));
                } else {
                    Collections.sort(list, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            if(o1.recommend == o2.recommend) {
                                return o1.time - o2.time;
                            } else {
                                return o1.recommend - o2.recommend;
                            }
                        }
                    });
                    list.remove(0);
                    list.add(new Student(num, i, 1));
                }
            }
        }

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.num - o2.num;
            }
        });

        for(Student student : list) {
            System.out.print(student.num + " ");
        }
    }
    static class Student {
        int num;
        int time;
        int recommend;

        public Student(int num,  int time, int recommend) {
            this.num = num;
            this.time = time;
            this.recommend = recommend;
        }

        public int compareTo(Student o) {
            if(this.recommend == o.recommend) {
                return this.time - o.time;
            } else {
                return this.recommend - o.recommend;
            }
        }
    }
}
