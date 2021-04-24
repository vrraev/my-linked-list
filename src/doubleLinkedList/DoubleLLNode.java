package doubleLinkedList;

public class DoubleLLNode<E> {
    DoubleLLNode<E> prev;
    DoubleLLNode<E> next;
    E value;

    public DoubleLLNode()
    {
        this.value = null;
        this.prev = null;
        this.next = null;
    }

    public DoubleLLNode(E e)
    {
        this.value = e;
        this.prev = null;
        this.next = null;
    }

    public DoubleLLNode(E e, DoubleLLNode<E> prevNode)
    {
        this(e, prevNode, prevNode.next);
        //prevNode.next.prev = this;
        //this.next = prevNode.next;
        //prevNode.next = this;
        //this.prev = prevNode;
    }

    public DoubleLLNode(E e, DoubleLLNode<E> prevNode, DoubleLLNode<E> nextNode)
    {
        this(e);
        prevNode.next = this;
        nextNode.prev = this;
        this.next = nextNode;
        this.prev = prevNode;
    }

    public String toString() {
        return "{Data: " + String.valueOf(this.value) + "}"; //+ ", Prev: " + String.valueOf(this.prev) + ", Next: " + String.valueOf(this.next) + "}";
    }
}
