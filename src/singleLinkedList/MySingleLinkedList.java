package singleLinkedList;

import java.util.AbstractList;

public class MySingleLinkedList<E> extends AbstractList<E> {
    private SingleLLNode<E> head;
    private SingleLLNode<E> tail;
    private int size;

    public MySingleLinkedList() {
        this.head = new SingleLLNode<>();
        this.tail = new SingleLLNode<>();
        this.head.pointer = null;
        this.tail.pointer = null;
        this.size = 0;
    }

    public E get(int index) {
        String errMsg = "Required index is smaller than list size.";
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(errMsg);
        }
        SingleLLNode<E> n = this.head.pointer;
        for (int i = 0; i < index; i++) {
            n = n.pointer;
        }
        return n.value;
    }

    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException("null is not allowed to be added.");
        }
        SingleLLNode<E> n = new SingleLLNode<>(element);
        if (this.head.pointer == null){
            this.head.pointer = n;
            this.tail.pointer = n;
            this.size++;
            return true;
        }
        this.tail.pointer.pointer = n;
        this.tail.pointer = n;
        n.pointer = null;
        this.size++;
        return true;
    }

    public void add(E element, int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Required index is smaller than list size.");
        }
        if (element == null) {
            throw new NullPointerException("null is not allowed to be added.");
        }
        SingleLLNode<E> nodePrevIndex = this.head;
        for (int i = 0; i < index; i++) {
            nodePrevIndex = nodePrevIndex.pointer;
        }
        SingleLLNode<E> nodeNew = new SingleLLNode<>(element);
        nodeNew.pointer = nodePrevIndex.pointer;
        nodePrevIndex.pointer = nodeNew;
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Required index is bigger than list size.");
        }
        SingleLLNode<E> nodeAtIndex = this.head;
        for (int i = 0; i < index; i++) {
            nodeAtIndex = nodeAtIndex.pointer;
        }
        nodeAtIndex.pointer = nodeAtIndex.pointer.pointer;
        this.size--;
        if (index == this.size + 2){
            this.tail = nodeAtIndex;
        }
        return nodeAtIndex.value;
    }

    public E set(int index, E element) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Required index is bigger than list size.");
        }
        if (element == null) {
            throw new NullPointerException("null is not allowed to be added.");
        }
        SingleLLNode<E> nodeAtIndex = this.head;
        for (int i = 0; i <= index; i++) {
            nodeAtIndex = nodeAtIndex.pointer;
        }
        E nodeData = nodeAtIndex.value;
        nodeAtIndex.value = element;
        return nodeData;
    }

    public String toString() {
        String result = "{ ";
        SingleLLNode<E> nodes = this.head.pointer;
        for (int i = 0; i < this.size; i++) {
            result = result.concat(nodes.toString() + " ");
            nodes = nodes.pointer;
        }
        result = result.concat("}");
        return result;
    }
}
