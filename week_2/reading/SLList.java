package reading;

/** An reading.SLList is a list of integers, which hides the terrble
 * truth of the nakedness within.
 */
public class SLList<Type> {
    private class TypeNode {
        public Type item;
        public TypeNode next;

        public TypeNode(Type i, TypeNode n) {
            item = i;
            next = n;
        }
    }

    private int size;
    /* The first item (if it exists) is at sentinel.next*/
    private final TypeNode sentinel;

    public SLList(){
        sentinel = new TypeNode(null, null);
        size = 0;
    }
    public SLList(Type x) {
        sentinel = new TypeNode(null, null);
        sentinel.next = new TypeNode(x, null);
        size = 1;
    }

    public void addFirst(Type x) {
        sentinel.next = new TypeNode(x, sentinel.next);
        size++;
    }

    public Type getFirst() {
        return sentinel.next.item;
    }

    public void addLast(Type x){
        size++;
        TypeNode ptr = sentinel;

        while (ptr.next != null){
            ptr = ptr.next;
        }
        ptr.next = new TypeNode(x, null);
    }

    public int size() {
//        return size(first);
        return size;
    }

//    private int size(TypeNode p){
//        if (p.next == null) return 1;
//        return 1 + size(p.next);
//    }

    public static void main(String[] args) {
        SLList<Integer> L = new SLList<>(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        int x = L.getFirst();
        System.out.println(x);
        System.out.println(L.size());
    }
}