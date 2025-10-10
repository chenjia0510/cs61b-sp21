package deque;


import java.util.Iterator;
import afu.org.checkerframework.checker.igj.qual.I;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    private int size;
    private ItemNode sentinel;

    //有用到外部T，所以不static
    public class ItemNode{
        public T item;
        ItemNode prev;
        ItemNode next;


        public ItemNode(T data,ItemNode p,ItemNode n){
            item=data;
            prev=p;
            next=n;
        }
    }
    public LinkedListDeque(){
        sentinel=new ItemNode(null,null,null);
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
        size=0;

    }



    public void addFirst(T item){
    /*
    Adds an item of type T to the front of the deque.
    You can assume that item is never null.
     */
        ItemNode near=sentinel.next;
        sentinel.next=new ItemNode(item,sentinel,near);
        near.prev=sentinel.next;
        size++;

    }



    public void addLast(T item){
        ItemNode near=sentinel.prev;
        sentinel.prev=new ItemNode(item,near,sentinel);
        near.next=sentinel.prev;
        size++;
    }



    public int size(){
        //Returns the number of items in the deque.
        return size;
    }

    public void printDeque(){
        //Prints the items in the deque from first to last, separated by a space.
        // Once all the items have been printed, print out a new line.
        ItemNode last=sentinel.prev;
        ItemNode pointer=sentinel.next;

        while(pointer!=last){
            System.out.print(pointer.item+" ");
            pointer=pointer.next;
        }
        System.out.println();
    }


    public T removeFirst(){
        //Removes and returns the item at the front of the deque.
        // If no such item exists, returns null.
        if (size==0){
            return null;
        }
        T x=sentinel.next.item;
        ItemNode near=sentinel.next.next;
        sentinel.next=near;
        near.prev=sentinel;
        size--;
        return x;



    }

    public T removeLast(){
        //前一個的next變成sentinel
        //sentinel的prev變成前一個
        //Removes and returns the item at the back of the deque.
        // If no such item exists, returns null.
        if(size==0) return null;

        T x=sentinel.prev.item;
        ItemNode near=sentinel.prev.prev;
        near.next=sentinel;
        sentinel.prev=near;
        size--;
        return x;

    }

    public T get(int index){
        // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
        // If no such item exists, returns null. Must not alter the deque!
        if (size==0){
            return null;
        }
        int count=0;
        ItemNode pointer=sentinel.next;
        ItemNode last=sentinel.prev;
        //不，
        while(pointer!=last&&count<index){
            pointer=pointer.next;
            count++;
        }
        if(count==index){
            return pointer.item;
        }else{
            //沒有這個index
            return null;
        }

    }
    private T getRecursive_helper(ItemNode n,int index){
        /**
         index 0 直接return->base case
         n=sentinel的話，代表沒有這個index,回傳null->base case

         index>0 找下一個node的index-1
         */
        //base case1:n=sentinel代表過頭了，沒這項
        //sentinel&&index==0代表deque是空的情況下
        if (n==sentinel||(n==sentinel&&index==0)){
            return null;
        }
        else if(index==0){
            return n.item;
        }

        return getRecursive_helper(n.next,index-1);

    }


    public T getRecursive(int index){
        return getRecursive_helper(sentinel.next,index);
    }



    public Iterator<T> iterator(){
        return new LLDequeIterator();
    }

    private class LLDequeIterator implements Iterator<T>{
        private int wizPos;

        public LLDequeIterator(){
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
        if (!(o instanceof Deque)){
            return false;

        }
        LinkedListDeque d2=(LinkedListDeque) o;
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
