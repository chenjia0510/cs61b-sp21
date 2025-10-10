package deque;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    int GPA;
    int height;
    String name;

    public Student(int g, int h, String n) {
        GPA = g;
        height = h;
        name = n;
    }

    public int compareTo(Student T) {
        return GPA - T.GPA;
    }

    private static class NameComparator implements Comparator<Student> {
        public int compare(Student a, Student b) {
            return a.name.compareTo(b.name);//string內建比較方法
        }
    }

    private static class HeightComparator implements Comparator<Student> {
        public int compare(Student a, Student b) {
            return a.height - b.height;
        }
    }

    public static Comparator<Student> getNameComparator() {
        return new NameComparator();
    }

    public static Comparator<Student> getHeightComparator() {
        return new HeightComparator();
    }

}