package leon.training.datastructure.imp;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import leon.training.utils.Utils;

/**
 * Created by leon on 2017/9/16.
 */

public class MSearchBinaryTree {

    private static class TreeNode implements Serializable {

        public int data;
        public TreeNode parent;
        public TreeNode leftChild;
        public TreeNode rightChild;

        public TreeNode() {

        }

        public TreeNode(int data, TreeNode parent, TreeNode leftChild, TreeNode rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.parent = parent;
        }
    }


    private TreeNode root;


    public MSearchBinaryTree() {

    }


    /*****************************创建搜索二叉树 start**************************/

    /**
     * 构建二叉树
     */
    private void createBinaryTree() {


    }


    /*****************************添加TreeNode start**************************/


    /**
     *       A
     *    B     C
     * D   E      F
     */
    public void add(int data) {
        if (root == null) {
            root = new TreeNode(data, null, null, null);
            return;
        }

        TreeNode node = root;
        while (node != null) {
            if (data < node.data) {
                if (node.leftChild != null) {
                    node = node.leftChild;
                } else {
                    node.leftChild = new TreeNode(data, node, null, null);
                    return;
                }
            } else if (data > node.data) {
                if (node.rightChild != null) {
                    node = node.rightChild;
                } else {
                    node.rightChild = new TreeNode(data, node, null, null);
                    return;
                }
            } else {
                //相等返回
                return;
            }
        }
    }

    /*****************************删除TreeNode start**********************************/
    /**
     * 删除搜索二叉树：
     *     情景一：无左孩子，无右孩子
     *          删除自己
     *     情景二：无左孩子，有右孩子
     *          删除自己
     *     情景三：有左孩子，无右孩子
     *          删除自己
     *     情景四：有左孩子，有右孩子
     *          要找到它的后继节点，右树中的最小值，自己的第一个右parent
     */
    public int delete(int key){
        TreeNode node = find(key);
        if(node == null){
            return -1;
        }

        //删除节点
        return deleteNode(node);
    }

    public int deleteNode(TreeNode node){
        if(node == null){
            return -1;
        }

        TreeNode parent = node.parent;

        //情景一：无左、右孩子
        if (node.leftChild == null && node.rightChild == null) {
            if (node == parent.leftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return 1;
        }

        //情景二：有左孩子，无右孩子
        if(node.leftChild != null && node.rightChild == null){
            if(node == parent.leftChild){
                parent.leftChild = node.leftChild;
            }else{
                parent.rightChild = node.leftChild;
            }
            return 1;
        }

        //情景三：无左孩子,有右孩子
        if(node.leftChild == null && node.rightChild != null){
            if(node == parent.leftChild){
                parent.leftChild = node.rightChild;
            }else{
                parent.rightChild = node.rightChild;
            }
            return 1;
        }

        //情景三：有左孩子,有右孩子
        if(node.leftChild != null && node.rightChild != null){
            TreeNode next = getNextNode(node);
            deleteNode(next);
            node.data = next.data;
        }

        return 1;
    }

    /**
     * 查询后继节点
     *    如果右孩子存在，要找右孩子中最小的节点，在右树中最左边，
     *    如果右孩子不存在，
     *
     * @return
     */
    private TreeNode getNextNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        //如果右孩子存在
        if (node.rightChild != null) {
            return getMinTreeNode(node.rightChild);
        }

        TreeNode parent = node.parent;
        while (parent != null && parent.rightChild == node) {
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    /**
     * 查询最小值
     * @return
     */
    private TreeNode getMinTreeNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        while (node.leftChild != null) {
            node = node.leftChild;
        }

        return node;
    }

    /*****************************查询TreeNode start**********************************/

    /**
     * 查找key
     * @param key
     * @return
     */
    public TreeNode find(int key) {
        TreeNode node = root;
        while (node != null) {
            if (key < node.data) {
                node = node.leftChild;
            } else if (key > node.data) {
                node = node.rightChild;
            } else {
                //== 找到
                return node;
            }
        }
        return null;
    }


    /*****************************遍历二叉树 start**********************************/

    /**
     * 中序遍历
     */
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.leftChild);
        Utils.msg(String.valueOf(node.data));
        inOrder(node.rightChild);
    }




    /********************************测试 start*********************************/
    public static void main() {

        Utils.msg("\n创建二叉树 ");
        int[] data = {50, 40, 63, 85, 12, 1, 55, 45, 56};
        MSearchBinaryTree tree = new MSearchBinaryTree();
        for (int i :
                data) {
            tree.add(i);
        }
        Utils.msg(Arrays.toString(data));

        Utils.msg("\n递归中序遍历: ");
        tree.inOrder((TreeNode) Utils.deepClone(tree.root));

        Utils.msg("\n添加元素: " + 5);
        tree.add(5);
        tree.inOrder((TreeNode) Utils.deepClone(tree.root));

        Utils.msg("\n删除元素: " + 45);
        tree.delete(45);
        tree.inOrder((TreeNode) Utils.deepClone(tree.root));
    }

}
