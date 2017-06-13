package leon.training.structure.list;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by leon on 2017/3/19.
 */
public class MArrayList {

    /**
     * 默认初始化大小
     */
    private static final int DEFAULT_CAPCITY = 10;

    /**
     * 当前容量
     */
    private int theSize;

    /**
     * 存储数组
     */
    private Object[] items;

    /**
     * 构造方法
     *
     * @return
     */
    public MArrayList() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPCITY);
    }

    public MArrayList(int size) {
        theSize = 0;
        ensureCapacity(size);
    }

    /**
     * 确定容器大小
     */
    private void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }

        if (items == null) {
            items = new Object[newCapacity];
            return;
        }

        Object[] old = items;
        items = new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            items[i] = old[i];
        }
    }

    /**
     * 获取大小
     *
     * @return
     */
    public int size() {
        return theSize;
    }

    /**
     * 清除全部
     */
    public void clear() {
        // clear to let GC do its work
        for (int i = 0; i < size(); i++) {
            items[i] = null;
        }
        theSize = 0;
    }

    /******************************增加*********************************/

    /**
     * 增加
     *
     * @return
     */
    public void add(Object obj) {
        add(size(), obj);
    }

    /**
     * 在指定位置增加
     *
     * @param index
     * @param obj
     */
    public void add(int index, Object obj) {
        if (index > theSize || index < 0)
            throw new IndexOutOfBoundsException();

        if (items.length == size()) {
            int oldCapacity = size();
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            ensureCapacity(newCapacity);
        }

        for (int i = theSize; i > index; i--) {
            items[i] = items[i - 1];
        }

        items[index] = obj;
        theSize++;
    }

    /*******************************删除*******************************/

    /**
     * 删除
     *
     * @param index
     * @return
     */
    public Object remove(int index) {
        if (index >= theSize)
            throw new IndexOutOfBoundsException();

        Object reItem = items[index];
        for (int i = index; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        theSize--;
        return reItem;
    }

    /*******************************修改*******************************/

    /**
     * @param index
     * @param obj
     * @return
     */
    public Object set(int index, Object obj) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Object old = items[index];
        items[index] = obj;
        return old;
    }


    /*******************************查询*******************************/

    /**
     * @param index
     * @return
     */
    public Object get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return items[index];
    }


    /**
     *  内部迭代器
     */
    private class ListIterator implements Iterator{

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public Object next() {
            return items[current++];
        }

        @Override
        public void remove() {
            MArrayList.this.remove(--current);
        }

        @Override
        public void forEachRemaining(Consumer action) {

        }
    }


    /**
     *
     */
    public static void main(){






    }
}
