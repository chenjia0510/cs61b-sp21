package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>,Deque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    public ArrayDeque(){
        size=0;
        items=(T[])new Object[8];
        nextFirst=3;
        nextLast =4;
    }

    public void addFirst(T item){
        //Adds an item of type T to the front of the deque. You can assume that item is never null.
        size++;
        items[nextFirst]=item;
        nextFirst=(nextFirst-1+ items.length)% items.length;

        if(size== items.length){
            resize(2 * size);
        }



    }
    public void addLast(T item){
        //Adds an item of type T to the back of the deque. You can assume that item is never null.
        size++;
        items[nextLast]=item;
        nextLast=(nextLast+1+ items.length)% items.length;
        if(size== items.length){
            resize(2 * size);
        }

    }
    private void resize(int capacity){
        T[] a=(T []) new Object[capacity];
        for(int i=0;i<size;i++){
            a[i]=items[((nextFirst+1+i)+ items.length)%items.length];
        }
        nextFirst=(-1+capacity)%capacity;
        nextLast=size;
        items=a;


    }



    public int size(){
    //Returns the number of items in the deque.
        return size;
    }
    public void printDeque(){
    //Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line.
        for(int i=0;i<size;i++){
            System.out.println(items[(nextFirst+1+i+ items.length)% items.length]);
        }
    }
    public T removeFirst(){
    //Removes and returns the item at the front of the deque. If no such item exists, returns null.

        T val=items[(nextFirst+1+ items.length)% items.length];
        items[(nextFirst+1+ items.length)% items.length]=null;
        if(size>0) {
            size--;
        }
        nextFirst=(nextFirst+1+ items.length)% items.length;
        if(items.length>=16&&((double)size/ (double)items.length)<0.25){
            resize((int)((double)items.length* 0.5));
        }
        return val;
    }

    public T removeLast(){
    //Removes and returns the item at the back of the deque. If no such item exists, returns null.
        T val=items[(nextLast-1+ items.length)%items.length];
        items[(nextLast-1+ items.length)%items.length]=null;
        if(size>0) {
            size--;
        }
        nextLast=(nextLast-1+ items.length)%items.length;
        if(items.length>=16&&((double)size/ (double)items.length)<0.25){
            resize((int)((double)items.length* 0.5));
        }
        return val;
    }

    public T get(int index){
    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
    //In addition, we also want our two Deques to implement these two special methods:
        if(index>=size){
            return null;
        }
        return items[(index+nextFirst+1+ items.length)% items.length];
    }



    public Iterator<T> iterator(){
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T>{
        private int wizPos;

        public ArrayDequeIterator(){
            wizPos=0;
        }

        public boolean hasNext(){
            return wizPos<size;
        }
        public T next(){
            T returnItem=get(wizPos);
            wizPos++;
            return returnItem;
        }

    }
    public boolean equals(Object o){
        if (o==this){
            return true;
        }
        if (!(o instanceof ArrayDeque)){
            return false;

        }
        ArrayDeque d2=(ArrayDeque) o;
        if(d2.size()==this.size()){
            for(int i=0;i<size;i++){
                if (this.get(i)!=d2.get(i)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }



}
