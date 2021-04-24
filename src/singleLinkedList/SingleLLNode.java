package singleLinkedList;

public class SingleLLNode<E> {
    SingleLLNode<E> pointer;
    E value;

    public SingleLLNode()
    {
        this.value = null;
        this.pointer = null;
    }

    public SingleLLNode(E e)
    {
        this.value = e;
        this.pointer = null;
    }

    public String toString() {
        return "{Data: " + String.valueOf(this.value) + "}"; //+ ", Prev: " + String.valueOf(this.prev) + ", Next: " + String.valueOf(this.next) + "}";
    }
}
