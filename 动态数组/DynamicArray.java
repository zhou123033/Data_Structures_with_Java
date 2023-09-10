import java.util.Iterator;
import java.util.function.Consumer;

/** 动态数组 */
public class DynamicArray implements Iterable<Integer> {
    private int size = 0; // 逻辑大小
    private int capacity = 8; // 容量
    private int[] array = {};


    public void addLast(int element) {
        add(size, element);
    }

    public void add(int index, int element) {
        // 容量检查
        checkAndGrow();

        // 添加逻辑
        if (index >= 0 && index <= size - 1) {
            System.arraycopy(array, index,
                    array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    private void checkAndGrow() { // 扩容
        // 容量检查
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {
            // 进行扩容
            capacity = capacity * 2;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public int get(int index) { // [0, size)
        return array[index];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() { // 有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() { // 返回当前元素，并移动到下一个元素
                return array[i++];
            }
        };
    }

    public int remove(int index) {
        int removed = array[index];
        System.arraycopy(array, index + 1,
                array, index, size - index - 1);
        size--;
        return removed;
    }

}
