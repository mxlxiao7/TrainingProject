package leon.training.datastructure.imp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

import leon.training.utils.Utils;

/**
 * Created by leon on 2017/9/15.
 */

public class MBinaryTree {
    private static class TreeNode implements Serializable {

        public int index;
        public char data;
        public TreeNode leftChild;
        public TreeNode rightChild;

        public TreeNode() {

        }

        public TreeNode(int index, char data, TreeNode leftChild, TreeNode rightChild) {
            this.index = index;
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    private TreeNode root;

    public MBinaryTree() {
        this.root = new TreeNode(1, 'A', null, null);
    }


    /*****************************创建二叉树 start**************************/

    /**
     * 构建二叉树
     *      A
     *   B     C
     * D   E      F
     */
    private void createBinaryTree() {
        TreeNode b = new TreeNode(2, 'B', null, null);
        TreeNode c = new TreeNode(3, 'C', null, null);
        TreeNode d = new TreeNode(4, 'D', null, null);
        TreeNode e = new TreeNode(5, 'E', null, null);
        TreeNode f = new TreeNode(6, 'F', null, null);

        root.leftChild = b;
        root.rightChild = c;
        b.leftChild = d;
        b.rightChild = e;
        c.rightChild = f;
    }




    /*****************************构造二叉树 start**********************************/

    /**
     *             A
     *         B       C
     *      D    E   #    F
     *    #   # # #     #   #
     *
     * ABD##E##C#F##
     * 通过前序遍历反向生成二叉树
     *
     */
    public static MBinaryTree createBinaryTree(List<String> data) {
        MBinaryTree tree = new MBinaryTree();
        tree.createBinaryTreePre(data.size(), data);
        return tree;
    }


    private TreeNode createBinaryTreePre(int size, List<String> data) {
        if (data.size() == 0) {
            return null;
        }

        String s = data.get(0);
        TreeNode node;
        int index = size - data.size();
        if (s.equals("#")) {
            data.remove(0);
            return null;
        }
        node = new TreeNode(index, s.charAt(0), null, null);
        if (index == 0) {
            root = node;
        }
        data.remove(0);
        node.leftChild = createBinaryTreePre(size, data);
        node.rightChild = createBinaryTreePre(size, data);
        return node;
    }



//    已知一棵二叉树的前根序序列和中根序序列，构造该二叉树的过程如下：
//            1. 根据前根序序列的第一个元素建立根结点；
//            2. 在中根序序列中找到该元素，确定根结点的左右子树的中根序序列；
//            3. 在前根序序列中确定左右子树的前根序序列；
//            4. 由左子树的前根序序列和中根序序列建立左子树；
//            5. 由右子树的前根序序列和中根序序列建立右子树。
//



//    已知一棵二叉树的后根序序列和中根序序列，构造该二叉树的过程如下：
//            1. 根据后根序序列的最后一个元素建立根结点；
//            2. 在中根序序列中找到该元素，确定根结点的左右子树的中根序序列；
//            3. 在后根序序列中确定左右子树的后根序序列；
//            4. 由左子树的后根序序列和中根序序列建立左子树；
//            5. 由右子树的后根序序列和中根序序列建立右子树。


    /*****************************遍历二叉树 start**********************************/

    //前序遍历: 先遍历根节点，然后遍历左孩子，然后遍历右孩子
    //中序遍历: 先遍历左孩子，然后遍历根节点，然后遍历右孩子
    //后序遍历: 先遍历左孩子，然后遍历右孩子，然后遍历根节点


    /**
     * 前序遍历二叉树
     *
     * @param node
     */
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Utils.msg(String.valueOf(node.data));
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    /**
     * 非递归前序遍历
     *
     * @param node
     */
    public void nonPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);

        while (!stack.isEmpty()) {
            //出栈
            TreeNode n = stack.pop();
            //先遍历根节点
            Utils.msg(String.valueOf(n.data));

            //压入子节点：这里因为是先序遍历，遍历完根节点后，要先遍历左孩子，先遍历的在栈顶，所以先压入右孩子，再压入左孩子。
            if (n.rightChild != null) {
                stack.push(n.rightChild);
            }
            if (n.leftChild != null) {
                stack.push(n.leftChild);
            }
        }
    }


    /**
     * 中序遍历二叉树
     *
     * @param node
     */
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.leftChild);
        Utils.msg(String.valueOf(node.data));
        inOrder(node.rightChild);
    }

    /**
     * 非递归中序遍历
     *
     * @param node
     */
    public void nonInOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        if (node.leftChild != null) {
            stack.push(node.leftChild);
            node.leftChild = null;
        }


        while (!stack.isEmpty()) {
            //出栈
            TreeNode n = stack.pop();
            //压入子节点：这里因为是中序遍历，要先遍历左孩子，先遍历的在栈顶，所以要判断当前节点有无左孩子，
            //   1.如果有左孩子：就要先压入当前节点，后压入左孩子，还要把当前节点的左孩子赋值为空
            //   2.如果没有做孩子：先遍历当前节点，然后根据判断压入右孩子
            if (n.leftChild != null) {
                stack.push(n);
                stack.push(n.leftChild);
                n.leftChild = null;
            } else {
                Utils.msg(String.valueOf(n.data));
                if (n.rightChild != null) {
                    stack.push(n.rightChild);
                }

            }
        }
    }


    /**
     * 后序遍历二叉树
     *
     * @param node
     */
    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        Utils.msg(String.valueOf(node.data));
    }

    /**
     *       A
     *    B     C
     *  D   E      F
     *
     * 非递归后序遍历二叉树
     * @param node
     */
    public void nonPostOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        if (node.rightChild != null) {
            stack.push(node.rightChild);
            node.rightChild = null;
        }
        if (node.leftChild != null) {
            stack.push(node.leftChild);
            node.leftChild = null;
        }

        while (!stack.isEmpty()) {
            //出栈
            TreeNode n = stack.pop();

            if (n.leftChild != null) {
                stack.push(n);
                stack.push(n.leftChild);
                n.leftChild = null;
            } else {
                if (n.rightChild != null) {
                    stack.push(n);
                    stack.push(n.rightChild);
                    n.rightChild = null;
                } else {
                    Utils.msg(String.valueOf(n.data));
                }
            }
        }
    }



    /*****************************求二叉树的（高度、层次） start**************************/
    /**
     * 求二叉树的（高度、层次）
     *
     * @return
     */
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int i = getHeight(node.leftChild);
        int j = getHeight(node.rightChild);
        return i > j ? i + 1 : j + 1;
    }


    /*****************************求二叉树的（节点数） start**************************/

    /**
     * 求二叉树的（节点数）
     *
     * @return
     */
    public int getNodeSize() {
        return getNodeSize(root);
    }

    public int getNodeSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getNodeSize(node.leftChild) + getNodeSize(node.rightChild) + 1;
    }


    /*****************************求二叉树的（最大节点） start**************************/
    /**
     * 求二叉树的（最大节点）
     *
     * @return
     */
    public TreeNode getMaxNode() {
        return getMaxNode(root);
    }


    private TreeNode getMaxNode(TreeNode node) {
        if (node == null) {
            return node;
        }

        TreeNode maxLeft = getMaxNode(node.leftChild);
        TreeNode maxRight = getMaxNode(node.rightChild);

        if (maxLeft != null && maxRight != null) {
            TreeNode max = maxLeft.data > maxRight.data ? maxLeft : maxRight;
            return node.data > max.data ? node : max;
        } else {
            if (maxLeft != null) {
                return node.data > maxLeft.data ? node : maxLeft;
            }
            if (maxRight != null) {
                return node.data > maxRight.data ? node : maxRight;
            }
        }
        return node;
    }


    /********************************测试 start*********************************/
    public static void main() {
        MBinaryTree tree = new MBinaryTree();
        tree.createBinaryTree();

        Utils.msg("\n求二叉树的深度: " + tree.getHeight());
        Utils.msg("\n求二叉树的节点数: " + tree.getNodeSize());
        Utils.msg("\n求二叉树的最大节点数: " + tree.getMaxNode().data);

        Utils.msg("\n前序遍历二叉树:\n");
        tree.preOrder((TreeNode) Utils.deepClone(tree.root));
        Utils.msg("\n非递归前序遍历二叉树:\n");
        tree.nonPreOrder((TreeNode) Utils.deepClone(tree.root));

        Utils.msg("\n中序遍历二叉树:\n");
        tree.inOrder((TreeNode) Utils.deepClone(tree.root));
        Utils.msg("\n非递归中序遍历二叉树:\n");
        tree.nonInOrder((TreeNode) Utils.deepClone(tree.root));

        Utils.msg("\n后序遍历二叉树:\n");
        tree.postOrder((TreeNode) Utils.deepClone(tree.root));
        Utils.msg("\n非递归后序遍历二叉树:\n");
        tree.nonPostOrder((TreeNode) Utils.deepClone(tree.root));

        Utils.msg("\n反序列化前序创建二叉树:");
        String s = "ABD##E##C#F##";
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            data.add(String.valueOf(s.charAt(i)));
        }
        tree = MBinaryTree.createBinaryTree(data);
        Utils.msg("反序列化数据：" + s);
        Utils.msg("前序遍历二叉树:");
        tree.preOrder((TreeNode) Utils.deepClone(tree.root));

    }
}
