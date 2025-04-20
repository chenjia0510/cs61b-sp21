package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */


public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove(){
        // YOUR TESTS HERE
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();
        a.addLast(4);
        b.addLast(4);
        a.addLast(5);
        b.addLast(5);
        a.addLast(6);
        b.addLast(6);
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());

    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                L2.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
//                System.out.println("size: " + size);
            }else if (operationNumber == 2){
                if (L.size()>0&&L2.size()>0) {
                    assertEquals(L.getLast(), L2.getLast());
                }
            }else if (operationNumber == 3){
                if (L.size()>0&&L2.size()>0){
                    assertEquals(L.removeLast(), L2.removeLast());
                }
            }
        }
    }

}



//package Arithmetic;
//
//import static org.junit.Assert.*;
//import org.junit.Test;
//
//public class ArithmeticTest {
//
//    /** Performs a few arbitrary tests to see if the product method is
//     * correct */
//@Test
//public void testProduct() {
//        /* assertEquals for comparison of ints takes two arguments:
//        assertEquals(expected, actual).
//        if it is false, then the assertion will be false,
//        and this test will fail.
//        */
//
//    assertEquals(30, Arithmetic.product(5, 6));
//    assertEquals(-30, Arithmetic.product(5, -6));
//    assertEquals(0, Arithmetic.product(0, -6));
//}
//
///** Performs a few arbitrary tests to see if the sum method is correct */
//@Test
//public void testSum() {
//
//    assertEquals(11, Arithmetic.sum(5, 6));
//    assertEquals(-1, Arithmetic.sum(5, -6));
//    assertEquals(-6, Arithmetic.sum(0, -6));
//    assertEquals(0, Arithmetic.sum(6, -6));
//}
//}






