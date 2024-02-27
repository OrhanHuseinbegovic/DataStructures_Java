package week1;

import java.util.Iterator;

public class DoublyLinkedList<Data> implements Iterable<Data> {
    private DoubleNode<Data> head;
    private DoubleNode<Data> tail;
    private int size = 0;

    /* Add a new node to the front of the doubly linked list */
    public void addToFront(Data data) {
        // your code
        DoubleNode<Data> newDoubleNode = new DoubleNode<>();
        newDoubleNode.data = data;
        newDoubleNode.next = head;
        head = newDoubleNode;
        head.prev = null;
        size++;
    }

    /* Remove a node from the front of the doubly linked list */
    public void removeFromFront() {
        // your code
        DoubleNode<Data> nextNode = head.next;
        head = nextNode;
        head.prev=null;
        size--;
    }

    /* Add a new node to the end of the doubly linked list */
    public void addToRear(Data data) {
        // your code
        DoubleNode<Data> newDoubleNode = new DoubleNode<>();
        newDoubleNode.data = data;
        DoubleNode<Data> current = head;
        int i = 0;
        while (i!=size && current!=null){
            if (current.next==null){
                current.next = newDoubleNode;
                newDoubleNode = null;
                size++;
                break;
            }
            i++;
            DoubleNode<Data> temp = new DoubleNode<>();
            temp = current;
            current = current.next;
            current.prev = temp;
        }
    }

    /* Remove a node at the end of the doubly linked list */
    public void removeFromRear() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            tail = null;
            size--;
            return;
        }
        DoubleNode<Data> current = head;
        while (current.next != null && current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
        size--;
    }


    /* Get a linked list node by index (0-indexed) */
    public Data get(int index) {
        // your code
        DoubleNode<Data> doubleNode = head;
        int i = 0;
        while (i!=index){
            doubleNode = doubleNode.next;
        }
        return doubleNode.data;
    }

    /* Add an element to a doubly linked list by index (0-index) */
    public void add(int index, Data data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }

        DoubleNode<Data> newNode = new DoubleNode<>();
        newNode.data = data;

        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            size++;
            return;
        }

        if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
            return;
        }

        DoubleNode<Data> current = head;
        int i = 0;
        while (i < index - 1) {
            current = current.next;
            i++;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    /* Delete an element from a doubly linked list by index (0-index) */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            size--;
            return;
        }
        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }
        DoubleNode<Data> current = head;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    /* Return the current size of the doubly linked list */
    public int count() {
        //your code
        return size;
    }

    /* Return an Iterator Object */
    @Override
    public Iterator<Data> iterator() {
        //your code
        return new DoublyLinkedListIterator();
    }

    /* Define the Iterator class, and hasNext() and next() methods */
    private class DoublyLinkedListIterator implements Iterator<Data> {
        //your code
        DoubleNode<Data> current = head;
        @Override
        public boolean hasNext() {
            //your code
            return current!=null;
        }

        @Override
        public Data next() {
            //your code
            Data data = current.data;
            current = current.next;
            return data;
        }
    }

    /* Get head node (for test purposes) */
    public DoubleNode<Data> getHead() {
        return head;
    }

    /* Get tail node (for test purposes) */
    public DoubleNode<Data> getTail() {
        return tail;
    }
}