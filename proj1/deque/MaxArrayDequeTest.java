package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList; // 匯入 Java 內建的 LinkedList 作為對照組
import edu.princeton.cs.algs4.StdRandom;
import java.util.Comparator;


/** Performs some basic linked list tests. */
public class MaxArrayDequeTest {


    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void comparatorsTest() {

        Student a=new Student(5,180,"Henry");
        Student b=new Student(3,135,"Amy");
        Student c=new Student(1,198,"Czz");
        Comparator<Student> nameComparator = Student.getNameComparator();
        Comparator<Student> heightComparator = Student.getHeightComparator();
        MaxArrayDeque t=new MaxArrayDeque(heightComparator);
        t.addLast(a);
        t.addLast(b);
        t.addLast(c);


        assertEquals(c,t.max());
        assertEquals(a,t.max(nameComparator));




    }


}
