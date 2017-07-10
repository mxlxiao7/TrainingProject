package leon.training.datastructure.list;

import java.util.Iterator;
import java.util.function.Consumer;

import leon.training.algorithm.Utils;

/**
 * Created by leon on 2017/3/20.
 */
public class MDLinkedList {

    private int size;
    private int modCount = 0;
    private Node first;
    private Node last;


    public MDLinkedList() {

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
        MDLinkedList.Node node = first;
        while (node != null) {
            s.append(node.data).append(",");
            node = node.next;
        }
        int i = s.lastIndexOf(",");
        if (i >= 0) {
            s.deleteCharAt(i);
        }
        s.append("]");
        Utils.msg(s.toString());
    }

    public MDLinkedList reverse() {
        if (first == null) {
            return this;
        }
        Node cur = first;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = cur.prev;
            cur.prev = next;
            if (next == null) {
                first = cur;
            }
            cur = next;
        }
        return this;
    }

    /********************************增加 start*********************************/

    /**
     * 增加
     *
     * @param obj
     * @return
     */
    public boolean add(Object obj) {
        add(size(), obj);
        return true;
    }

    /**
     * 增加
     *
     * @return
     */
    public void add(int index, Object obj) {
        checkPositionIndex(index);

        if (index == size()) {
            addLast(obj);
        } else {
            addBefore(getNode(index), obj);
        }
    }

    /**
     * 在 p 节点之前添加元素 obj
     *
     * @param p
     * @param obj
     * @return
     */
    private void addBefore(Node node, Object obj) {
        final Node pred = node.prev;
        final Node newNode = new Node(obj, pred, node);
        node.prev = newNode;

        //如果是头结点
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }

        size++;
        modCount++;
    }

    /**
     * 在末尾添加元素
     */
    private void addLast(Object p) {
        Node l = last;
        Node newNode = new Node(p, l, null);
        last = newNode;
        if (l == null) {//空链表，设置头结点
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }


    /********************************增加 end*********************************/

    /********************************删除 start*******************************/

    /**
     * 清除数据
     */
    public void clear() {
        Node node = first;
        while (node != null) {
            Node next = node.next;
            node.data = null;
            node.prev = null;
            node.next = null;
            node = next;
        }

        first = null;
        last = null;
        size = 0;
        modCount++;
    }

    /**
     * 删除
     *
     * @param index
     * @return
     */
    public Object remove(int index) {
        checkPositionIndex(index);
        Node delNode = getNode(index);
        return remove(delNode);
    }

    /**
     * 删除
     *
     * @return
     */
    public boolean remove(Object obj) {
        Node node = first;
        while (node != null) {
            if (obj.equals(node.data)) {
                remove(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 删除
     *
     * @return
     */
    private Object remove(Node x) {
        final Object element = x.data;
        final Node next = x.next;
        final Node prev = x.prev;

        //如果删除的是头结点
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        //如果删除的是末尾节点
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.data = null;
        size--;
        modCount++;
        return element;
    }

    /********************************删除 end*******************************/


    /********************************修改 start*******************************/

    /**
     * 修改
     *
     * @param index
     * @return
     */
    public Object set(int index, Object obj) {
        checkElementIndex(index);
        Node node = getNode(index);
        Object oldValue = node.data;
        node.data = obj;
        return oldValue;
    }

    /********************************修改 end*******************************/

    /********************************获取 start*******************************/

    /**
     * 是否包含 obj 元素
     *
     * @param obj
     * @return
     */
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        Node node = first;
        while (node != null) {
            if (obj.equals(node.data)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 获取
     *
     * @param index
     * @return
     */
    public Object get(int index) {
        checkElementIndex(index);
        return getNode(index).data;
    }

    /**
     * 获取
     *
     * @param index
     * @param lower
     * @param upper
     * @return
     */
    private Node getNode(int index) {
        checkElementIndex(index);
        Node node = null;

        if (index < size() >> 1) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size() - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    /********************************获取 end*******************************/

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
     * 内部类
     */
    private static class Node {
        public Object data;
        public Node prev;
        public Node next;

        public Node(Object obj, Node p, Node n) {
            this.data = obj;
            this.prev = p;
            this.next = n;
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
        MDLinkedList list = new MDLinkedList();
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
