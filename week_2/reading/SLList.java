package reading;

/** An reading.SLList is a list of integers, which hides the terrble
 * truth of the nakedness within.
 */
public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private int size;
    /* The first item (if it exists) is at sentinel.next*/
    private IntNode sentinel;

    public SLList(){
        sentinel = new IntNode(0, null);
        size = 0;
    }
    public SLList(int x) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x){
        size++;
        IntNode ptr = sentinel;

        while (ptr.next != null){
            ptr = ptr.next;
        }
        ptr.next = new IntNode(x, null);
    }

    public int size() {
//        return size(first);
        return size;
    }

//    private int size(IntNode p){
//        if (p.next == null) return 1;
//        return 1 + size(p.next);
//    }

    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        int x = L.getFirst();
        System.out.println(x);
        System.out.println(L.size());
    }
}