package leon.training.structure.list;

import java.util.Iterator;
import java.util.function.Consumer;

import leon.training.algorithm.Utils;

/**
 * Created by leon on 2017/3/14.
 */
public class MSLinkedList {

    private int modCount = 0;
    private Node root;
    private int size;

    public MSLinkedList() {

    }

    /**
     * 获取数量
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 显示
     */
    public void printList() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        Node node = root;
        while (node != null) {
            s.append(node.value).append(",");
            node = node.next;
        }
        int i = s.lastIndexOf(",");
        if (i >= 0) {
            s.deleteCharAt(i);
        }
        s.append("]");
        Utils.msg(s.toString());
    }

    /**
     * 新增
     *
     * @param obj
     */
    public void add(Object obj) {
        add(size(), obj);
    }

    /**
     * 新增
     *
     * @param index
     * @param obj
     */
    public void add(int index, Object obj) {
        checkPositionIndex(index);
        if (index == 0) {
            addAfter(null, obj);
        } else {
            addAfter(getNode(index - 1), obj);
        }
    }

    /**
     * 删除
     */
    public int remove(Object obj) {
        if (obj == null) {
            return -1;
        }
        Node node = root;
        Node pre = new Node(null, root);
        while (node != null) {
            if (node.value.equals(obj)) {
                pre.next = node.next;
                size--;
                modCount++;
                return 1;
            }
            node = node.next;
            pre = pre.next;
        }
        return -1;
    }


    /**
     * 删除
     */
    public Object remove(int index) {
        checkElementIndex(index);
        Object old = null;
        if (index == 0) {
            Node node = getNode(index);
            old = node.value;
            root = node.next;
        } else {
            Node node = getNode(index - 1);
            old = node.next.value;
            node.next = node.next.next;
        }
        size--;
        modCount++;
        return old;
    }

    /**
     * 清空数据
     */
    public void clear() {
        Node node = root;
        while (node != null) {
            Node next = node.next;
            node.value = null;
            node.next = null;
            node = next;
        }
        root = null;
        size = 0;
        modCount++;
    }

    /**
     * 修改
     *
     * @return
     */
    public Object set(int index, Object obj) {
        if (obj == null) {
            return null;
        }
        checkElementIndex(index);
        Node node = getNode(index);
        Object old = node.value;
        node.value = obj;
        return old;
    }

    /**
     * 判断是否包含
     *
     * @param obj
     * @return
     */
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        Node node = root;
        while (node != null) {
            if (obj.equals(node.value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 获取
     */
    public Object get(int index) {
        checkElementIndex(index);
        return getNode(index).value;
    }

    /**
     * 翻转
     */
    public MSLinkedList reverse() {
        Node cur = root;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        root = pre;
        return this;
    }


    /********************************私有 start*********************************/

    /**
     * 检查是否越界
     *
     * @param index
     */
    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size))
            throw new IndexOutOfBoundsException();
    }

    /**
     * Tells if the argument is the index of an existing element.
     */
    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size))
            throw new IndexOutOfBoundsException();
    }

    /**
     * 在 node 元素前插入 obj
     *
     * @param node
     * @param obj
     */
    private void addAfter(Node node, Object obj) {
        if (node == null) {
            node = new Node(obj, null);
            root = node;
        } else {
            node.next = new Node(obj, null);
        }
        size++;
        modCount++;
    }


    /**
     * @param index
     * @return
     */
    private Node getNode(int index) {
        checkElementIndex(index);
        Node node = root;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    public static class Node {
        public Object value;
        public Node next;

        Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 内部迭代器
     */
    private class ListIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer action) {

        }
    }


    /********************************测试 start*********************************/

    /**
     *
     */
    public static void main() {

        Utils.msg("\n--新增--");
        MSLinkedList list = new MSLinkedList();
        list.add("Android");
        list.add("Java");
        list.add("iOS");
        list.add("大数据");
        list.add("Web");
        list.add("SQL");
        list.add("PHP");
        list.add("Python");
        list.add("C++");

        list.printList();

        Utils.msg("\n--查找-- contains(iOS)");
        Utils.msg(list.contains("iOS") + "");

        Utils.msg("\n--查找-- get(0)");
        Utils.msg(list.get(0) + "");

        Utils.msg("\n--查找-- get(2)");
        Utils.msg(list.get(2) + "");

        Utils.msg("\n--查找-- get(5)");
        Utils.msg(list.get(5) + "");

        Utils.msg("\n--删除-- remove(Java)");
        list.remove("Java");
        list.printList();

        Utils.msg("\n--删除-- remove(0)");
        list.remove(0);
        list.printList();

        Utils.msg("\n--删除-- remove(list.size()-1)");
        list.remove(list.size() - 1);
        list.printList();

        Utils.msg("\n--翻转前--");
        list.printList();
        Utils.msg("\n--翻转后--");
        list.reverse().printList();

        Utils.msg("\n--清空--");
        list.clear();
        list.printList();
    }
}
