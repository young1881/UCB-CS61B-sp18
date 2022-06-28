package reading;

public class AList<T> {
    private int size;
    private T[] items;

    /** Creates an empty list. */
    public AList() {
        size = 0;
        items = (T[]) new Object[100];
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size == items.length) {
            resize((int) (size * 1.1));
        }
        items[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return items[size - 1];
    }

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item.
     */
    public T removeLast() {
        T res = items[size - 1];
        items[size - 1] = null;
        size--;
        return res;
    }

    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
}