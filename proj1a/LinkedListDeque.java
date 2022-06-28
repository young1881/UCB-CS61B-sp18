
public class LinkedListDeque<T> {
    private class TNode{
        TNode prev;
        T item;
        TNode next;

        public TNode(TNode p, T i, TNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private final TNode sentFront;
    private final TNode sentBack;
    private int size;

    public LinkedListDeque(){
        TNode first = new TNode(null, null, null);
        size = 0;
        sentFront = new TNode(null, null, null);
        sentBack = new TNode(null, null, null);
        sentFront.next = first;
        sentBack.next = first;
    }

    public LinkedListDeque(T i){
        TNode first = new TNode(null, i, null);
        size = 1;
        sentFront = new TNode(null, null, null);
        sentBack = new TNode(null, null, null);
        sentFront.next = first;
        sentBack.next = first;
    }

    public void addFirst(T item){
        size++;
        sentFront.next = new TNode(null, item, sentFront.next);
    }

    public void addLast(T item){
        size++;
        sentBack.next = new TNode(sentBack.next, item, null);
    }

    public boolean isEmpty(){
        return sentFront.next.next == null;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (TNode ptr = sentFront.next; ptr !=sentBack.next; ptr = ptr.next){
            if (ptr.next == null){
                System.out.println(ptr.item);
                break;
            }
            System.out.println(ptr.item + " ");
        }
    }
    public T removeFirst(){
        size--;
        if (sentFront.next == null) return null;
        T tmp = sentFront.next.item;
        sentFront.next = sentFront.next.next;
        return tmp;
    }

    public T removeLast(){
        size--;
        if (sentBack.next == null) return null;
        T tmp = sentBack.next.item;
        sentBack.next = sentBack.next.prev;
        return tmp;
    }

    public T get(int index){
        TNode ptr = sentFront.next;
        for(int i=0; i<index; i++){
            ptr = ptr.next;
        }
        return ptr.item;
    }

    public T getRecursive(int index){
        if (size < index){
            return null;
        }
        return getRecursive(sentFront.next, index);
    }

    public T getRecursive(TNode node, int i){
        if (i == 0) return node.item;
        return getRecursive(node.next, i-1);
    }
}