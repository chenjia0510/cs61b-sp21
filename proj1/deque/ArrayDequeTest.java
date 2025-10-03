package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList; // 匯入 Java 內建的 LinkedList 作為對照組
import edu.princeton.cs.algs4.StdRandom;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        ArrayDeque<String>  lld1 = new ArrayDeque<String>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigArrayDequeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void getTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        assertNull("Should have the null",lld1.get(0));
        for (int i=0;i<100;i++){
            lld1.addLast(i);
        }
        assertEquals("Should have the same value",(Integer) 99, lld1.get(99));


    }


    @Test
    public void testIterator() {
        // 創建一個有幾個元素的 deque
        // 使用 iterator 遍歷
        // 檢查是否按正確順序返回元素
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> lld2 = new ArrayDeque<Integer>();

        assertNull("Should have the null",lld1.get(0));
        for (int i=0;i<3;i++){
            lld1.addLast(i);
        }

        for (int item:lld1){
            lld2.addLast(item);
            System.out.println(item);
        }

        assertEquals(3,lld2.size());


    }


    @Test
    public void testEquals() {
        // 創建一個有幾個元素的 deque
        // 使用 iterator 遍歷
        // 檢查是否按正確順序返回元素
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> lld2 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> lld3 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> lld4 = new ArrayDeque<Integer>();

        assertNull("Should have the null",lld1.get(0));
        for (int i=0;i<3;i++){
            lld1.addLast(i);
        }

        for (int item:lld1){
            lld2.addLast(item);
        }
        for (int i=0;i<3;i++){
            lld4.addLast(i+1);
        }
        assertEquals(true,lld1.equals(lld2));
        assertEquals(false,lld1.equals(lld3));
        assertEquals(true,lld1.equals(lld1));
        assertEquals(false,lld1.equals(lld4));





    }


    @Test
    public void randomizedTest() {
        // 你的 ArrayDeque
        ArrayDeque<Integer> myDeque = new ArrayDeque<>();
        // 正確的、Java 官方的 Deque 實作
        LinkedList<Integer> correctDeque = new LinkedList<>();

        int N = 10000; // 執行的隨機操作次數
        for (int i = 0; i < N; i += 1) {
            // 每次操作後都檢查 size 是否一致
            assertEquals("Size should be equal", correctDeque.size(), myDeque.size());

            int operationNumber = StdRandom.uniform(0, 6); // 隨機選擇 0 到 5 的操作

            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                myDeque.addFirst(randVal);
                correctDeque.addFirst(randVal);
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                myDeque.addLast(randVal);
                correctDeque.addLast(randVal);
            } else if (operationNumber == 2) {
                // isEmpty
                assertEquals(correctDeque.isEmpty(), myDeque.isEmpty());
            } else if (operationNumber == 3 && myDeque.size() > 0) {
                // removeFirst
                Integer myVal = myDeque.removeFirst();
                Integer correctVal = correctDeque.removeFirst();
                assertEquals("removeFirst() should return the same value", correctVal, myVal);
            } else if (operationNumber == 4 && myDeque.size() > 0) {
                // removeLast
                Integer myVal = myDeque.removeLast();
                Integer correctVal = correctDeque.removeLast();
                assertEquals("removeLast() should return the same value", correctVal, myVal);
            } else if (operationNumber == 5 && myDeque.size() > 0) {
                // get
                int randIndex = StdRandom.uniform(0, myDeque.size());
                Integer myVal = myDeque.get(randIndex);
                Integer correctVal = correctDeque.get(randIndex);
                assertEquals("get(" + randIndex + ") should return the same value", correctVal, myVal);
            }
        }
    }

}
