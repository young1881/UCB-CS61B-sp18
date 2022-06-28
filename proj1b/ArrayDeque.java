public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int left;
    private int right;
    private int capacity = 8;

    public ArrayDeque(){
        items = (T[]) new Object[capacity];
        left = right = 0;
    }

    @Override
    public void addFirst(T item){
        if (isFull()) {
            resize((int) (capacity * 1.5));
        }
        left = (left - 1 + capacity) % capacity;
        items[left] = item;
    }

    @Override
    public void addLast(T item){
        if (isFull()) {
            resize((int) (capacity * 1.5));
        }
        items[right] = item;
        right = (right + 1) % capacity;
    }

    @Override
    public boolean isEmpty(){
        return ((right - left) == 0);
    }

    @Override
    public int size(){
        return (right - left + capacity) % capacity;
    }

    @Override
    public void printDeque(){
        if (left < right) {
            for (int i = left; i < right; i++) {
                if (i == right - 1) {
                    System.out.println(items[i]);
                    break;
                }
                System.out.print(items[i] + " ");
            }
        } else if (left > right) {
            for (int i = left; i < capacity; i++) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i < right; i++) {
                if (i == right - 1) {
                    System.out.println(items[i]);
                    break;
                }
                System.out.print(items[i] + " ");
            }
        }
    }

    @Override
    public T removeFirst(){
        if (isEmpty()) {return null;}
        T tmp = items[left];
        left = (left + 1) % capacity;
        if (isLowUsageRate()) {
            resize((int) (capacity * 0.5));
        }
        return tmp;
    }

    @Override
    public T removeLast(){
        if (isEmpty()) {return null;}
        T tmp = items[right - 1];
        right = (right - 1) % capacity;
        if (isLowUsageRate()) {
            resize((int) (capacity * 0.5));
        }
        return tmp;
    }

    @Override
    public T get(int index){
        if (index < 0 || index >= size() || isEmpty()) {
            return null;
        }
        if (left < right) {
            return items[index + left];
        } else {
            return items[(index + left) % capacity];
        }
    }

    private boolean isFull(){
        return size() == capacity - 1;
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];

        int size = size();
        if (left < right) {
            for (int i = left, j = 0; i < right && j < size; i++, j++) {
                newArray[j] = items[i];
            }
        } else if (left > right) {
            int j = 0;
            for (int i = left; j < capacity - left; i++, j++) {
                newArray[j] = items[i];
            }
            for (int i = 0; j < size; i++, j++) {
                newArray[j] = items[i];
            }
        }
        left = 0;
        right = size;
        items = newArray;
        capacity = newSize;
    }

    private boolean isLowUsageRate() {
        return capacity >= 16 && size() / (double) capacity < 0.25;
    }
}
