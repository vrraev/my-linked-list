package doubleLinkedList;

import java.util.AbstractList;

public class MyDoubleLinkedList<E> extends AbstractList<E> {
    private DoubleLLNode<E> head;
    private DoubleLLNode<E> tail;
    private int size;

    public MyDoubleLinkedList() {
        this.head = new DoubleLLNode<>();
        this.tail = new DoubleLLNode<>();
        this.head.next = this.tail;
        this.head.prev = null;
        this.tail.prev = this.head;
        this.tail.next = null;
        this.size = 0;
    }

    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException("null is not allowed to be added.");
        }
        DoubleLLNode<E> n = new DoubleLLNode<>(element);
        n.prev = this.tail.prev;
        n.prev.next = n;
        //this.tail.prev.next = n;
        n.next = this.tail;
        this.tail.prev = n;
        this.size++;
        return true;
    }

    public E get(int index) {
        String errMsg = "Required index is bigger than list size.";
        if (index < 0) {
            throw new IndexOutOfBoundsException(errMsg);
        }
        DoubleLLNode<E> n = this.head.next;
        for (int i = 0; i <= index; i++) {
            //n = n.next;
            if (n.next == null ) {
                break;
            } else if(i == index) {
                return n.value;
            }
            n = n.next;
        }
        throw new IndexOutOfBoundsException(errMsg);
    }

    public void add(int index, E element ) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Required index is bigger than list size.");
        }
        if (element == null) {
            throw new NullPointerException("null is not allowed to be added.");
        }
        DoubleLLNode<E> nodePrevIndex = this.head;
        for (int i = 0; i < index; i++) {
            nodePrevIndex = nodePrevIndex.next;
        }
        DoubleLLNode<E> nodeNew = new DoubleLLNode<>(element);
        nodePrevIndex.next.prev = nodeNew;
        nodeNew.next = nodePrevIndex.next;
        nodePrevIndex.next = nodeNew;
        nodeNew.prev = nodePrevIndex;
        this.size++;
    }

    public int size() {
//        int counter = 0;
//        DoubleLLNode<E> n = this.head;
//        while(n.next.next != null){
//            counter++;
//            n = n.next;
//        }
//        return counter;
        return this.size;
    }

    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Required index is bigger than list size.");
        }
        DoubleLLNode<E> nodeAtIndex = this.head;
        for (int i = 0; i <= index; i++) {
            nodeAtIndex = nodeAtIndex.next;
        }
        nodeAtIndex.prev.next = nodeAtIndex.next;
        nodeAtIndex.next.prev = nodeAtIndex.prev;
        this.size--;
        return nodeAtIndex.value;
    }

    public E set(int index, E element) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Required index is bigger than list size.");
        }
        if (element == null) {
            throw new NullPointerException("null is not allowed to be added.");
        }
        DoubleLLNode<E> nodeAtIndex = this.head;
        for (int i = 0; i <= index; i++) {
            nodeAtIndex = nodeAtIndex.next;
        }
        E nodeData = nodeAtIndex.value;
        nodeAtIndex.value = element;
        return nodeData;
    }

    public String toString() {
        String result = "{ ";
        DoubleLLNode<E> nodes = this.head.next;
        for (int i = 0; i < this.size; i++) {
            result = result.concat(nodes.toString() + " ");
            nodes = nodes.next;
        }
        result = result.concat("}");
        return result;
    }
}
