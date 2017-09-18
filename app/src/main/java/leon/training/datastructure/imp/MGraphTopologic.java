package leon.training.datastructure.imp;

import java.util.Stack;

import leon.training.function.multipleextends.Interface0;
import leon.training.utils.Utils;

/**
 * 拓扑结构
 * 使用邻接表数据结构
 */
public class MGraphTopologic {

    /**
     * 邻接顶点的一维数组
     */
    private VertexNode[] adjList;

    private int vertexSize;//顶点数量

    public MGraphTopologic(int vertexSize) {
        this.vertexSize = vertexSize;
        this.adjList = new VertexNode[vertexSize];
    }

    /**
     * 拓扑排序
     */
    public void topological() {
        Stack<Integer> stack = new Stack<Integer>();

        int count = 0;
        int k = 0;

        for (int i = 0; i < vertexSize; i++) {
            if (adjList[i].in == 0) {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            Utils.msg("顶点 ：" + adjList[pop].data);
            count++;
            EdgeNode node = adjList[pop].firstEdge;
            while (node != null) {
                k = node.adjVert;//下标
                if (--adjList[k].in == 0) {
                    stack.push(k);//入度为0，入栈
                }
                node = node.next;
            }
        }

        if(count < vertexSize){
            Utils.msg("拓扑排序失败" );
        }
    }


    /**
     * 边表顶点
     */
    static class EdgeNode {
        public int adjVert;
        public EdgeNode next;
        public int weight;

        public EdgeNode(int adjVert) {
            this.adjVert = adjVert;
        }
    }

    /**
     * 邻接点顶
     */
    static class VertexNode {
        public int in;//入度
        public String data;
        public EdgeNode firstEdge;

        public VertexNode(int in, String data) {
            this.in = in;
            this.data = data;
        }
    }


    /********************************测试 start*********************************/
    public static void main() {
        MGraphTopologic graph = new MGraphTopologic(14);

        VertexNode node0 = new VertexNode(0, "v0");
        VertexNode node1 = new VertexNode(0, "v1");
        VertexNode node2 = new VertexNode(2, "v2");
        VertexNode node3 = new VertexNode(0, "v3");
        VertexNode node4 = new VertexNode(2, "v4");
        VertexNode node5 = new VertexNode(3, "v5");
        VertexNode node6 = new VertexNode(1, "v6");
        VertexNode node7 = new VertexNode(2, "v7");
        VertexNode node8 = new VertexNode(2, "v8");
        VertexNode node9 = new VertexNode(1, "v9");
        VertexNode node10 = new VertexNode(1, "v10");
        VertexNode node11 = new VertexNode(2, "v11");
        VertexNode node12 = new VertexNode(1, "v12");
        VertexNode node13 = new VertexNode(2, "v13");

        graph.adjList[0] = node0;
        graph.adjList[1] = node1;
        graph.adjList[2] = node2;
        graph.adjList[3] = node3;
        graph.adjList[4] = node4;
        graph.adjList[5] = node5;
        graph.adjList[6] = node6;
        graph.adjList[7] = node7;
        graph.adjList[8] = node8;
        graph.adjList[9] = node9;
        graph.adjList[10] = node10;
        graph.adjList[11] = node11;
        graph.adjList[12] = node12;
        graph.adjList[13] = node13;

        node0.firstEdge = new EdgeNode(11);
        node0.firstEdge.next = new EdgeNode(5);
        node0.firstEdge.next.next = new EdgeNode(4);
        node1.firstEdge = new EdgeNode(8);
        node1.firstEdge.next = new EdgeNode(4);
        node1.firstEdge.next.next = new EdgeNode(2);
        node2.firstEdge = new EdgeNode(9);
        node2.firstEdge.next = new EdgeNode(6);
        node2.firstEdge.next.next = new EdgeNode(5);
        node3.firstEdge = new EdgeNode(13);
        node3.firstEdge.next = new EdgeNode(2);
        node4.firstEdge = new EdgeNode(7);
        node5.firstEdge = new EdgeNode(12);
        node5.firstEdge.next = new EdgeNode(8);
        node6.firstEdge = new EdgeNode(5);
        node8.firstEdge = new EdgeNode(7);
        node9.firstEdge = new EdgeNode(11);
        node9.firstEdge.next = new EdgeNode(10);
        node10.firstEdge = new EdgeNode(13);
        node12.firstEdge = new EdgeNode(9);


        Utils.msg("\n拓扑排序算法:  ");
        graph.topological();
    }

}
