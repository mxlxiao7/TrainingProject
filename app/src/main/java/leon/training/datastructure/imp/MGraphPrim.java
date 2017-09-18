package leon.training.datastructure.imp;

import java.util.LinkedList;

import leon.training.utils.Utils;

/**
 * Created by leon on 2017/9/17.
 */

public class MGraphPrim {

    private static final int MAX_WEIGHT = 65535;
    private int vertexSize;//顶点数量
    public int[] vertexs;//顶点数组
    public int[][] matrix;
    public boolean[] isVisited;


    public MGraphPrim(int vertexSize) {
        this.vertexSize = vertexSize;
        matrix = new int[vertexSize][vertexSize];
        vertexs = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            vertexs[i] = i;
        }
        isVisited = new boolean[vertexSize];
    }


    /**
     * 计算出度
     */
    public int getOutDegree(int index) {
        int degree = 0;
        for (int j = 0; j < matrix[index].length; j++) {
            int weight = matrix[index][j];
            if (weight != 0 && weight != MAX_WEIGHT) {
                degree++;
            }
        }
        return degree;
    }

    /**
     * 计算入度
     *
     * @return
     */
    public int getInDegree(int index) {
        int degree = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            int weight = matrix[i][index];
            if (weight != 0 && weight != MAX_WEIGHT) {
                degree++;
            }
        }
        return degree;
    }

    /**
     * 获取两个顶点之间的权值
     */
    public int getWeight(int v1, int v2) {
        int weight = matrix[v1][v2];
        return weight == 0 ? 0 : (weight == MAX_WEIGHT ? -1 : weight);
    }


    /**
     * 获取某个顶点的第一个邻点
     *
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexSize; j++) {
            if (matrix[index][j] > 0 && matrix[index][j] < MAX_WEIGHT) {
                return j;
            }
        }
        return -1;
    }


    /**
     * 根据前一个邻点的下标取得
     *
     * @param v1 要找的顶点
     * @param v2 表示该顶点相对于哪个邻节点去获取下一个邻节点
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexSize; j++) {
            if (matrix[v1][j] > 0 && matrix[v1][j] < MAX_WEIGHT) {
                return j;
            }
        }
        return -1;
    }

    /********************************深度优先遍历 start*********************************/

    /**
     * 图的深度优先遍历算法 DFS
     */
    public void depthFirstSearch() {
        isVisited = new boolean[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            if (!isVisited[i]) {
                Utils.msg("访问到了: " + i + " 的顶点");
                depthFirstSearch(i);
            }
        }
    }

    /**
     * 实现
     */
    private void depthFirstSearch(int i) {
        isVisited[i] = true;

        //获取第一个邻居
        int w = getFirstNeighbor(i);

        while (w != -1) {
            if (!isVisited[w]) {
                Utils.msg("访问到了: " + w + " 的顶点");
                depthFirstSearch(w);
            }

            //第一个相对于W的邻点
            w = getNextNeighbor(i, w);
        }
    }


    /********************************广度优先遍历 start*********************************/

    /**
     * 广度优先算法
     */
    public void broadFirstSearch() {
        isVisited = new boolean[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            if (!isVisited[i]) {
                broadFirstSearch(i);
            }
        }
    }

    /**
     * 实现广度优先算法
     */
    private void broadFirstSearch(int i) {
        int u;
        int w;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        Utils.msg("访问到了: " + i + " 的顶点");
        isVisited[i] = true;

        queue.add(i);
        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    Utils.msg("访问到了: " + w + " 的顶点");
                    isVisited[w] = true;
                    queue.add(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }


    /********************************最小生成树（普里姆） start*********************************/

    /**
     *  普里姆算法
     */
    public void prim() {
        //最小代价顶点权值的数组，为0表示已经相连
        int[] lowCost = new int[vertexSize];
        //放顶点权值
        int[] adjvex = new int[vertexSize];

        int min, minID, sum = 0;
        for (int i = 1; i < vertexSize; i++) {
            lowCost[i] = matrix[0][i];
        }

        for (int i = 1; i < vertexSize; i++) {
            min = MAX_WEIGHT;
            minID = 0;

            for (int j = 1; j < vertexSize; j++) {
                //有效权值
                if (lowCost[j] < min && lowCost[j] > 0) {
                    min = lowCost[j];
                    minID = j;
                }
            }

            Utils.msg("顶点: " + adjvex[minID] + " 权值： " + min);
            sum += min;
            lowCost[minID] = 0;

            for (int j = 1; j < vertexSize; j++) {
                if (lowCost[j] != 0 && matrix[minID][j] < lowCost[j]) {
                    lowCost[j] = matrix[minID][j];
                    adjvex[j] = minID;
                }
            }
        }

        Utils.msg("最小生成树权值和： " + sum);
    }


    /********************************测试 start*********************************/
    public static void main() {

        Utils.msg("\n创建图 ");
        MGraphPrim graph = new MGraphPrim(9);
        int[] a0 = new int[]{0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a1 = new int[]{10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12};
        int[] a2 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8};
        int[] a3 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, MAX_WEIGHT, 16, 21};
        int[] a4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT};
        int[] a5 = new int[]{11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT};
        int[] a6 = new int[]{MAX_WEIGHT, 16, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT};
        int[] a7 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT};
        int[] a8 = new int[]{MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};
        graph.matrix[0] = a0;
        graph.matrix[1] = a1;
        graph.matrix[2] = a2;
        graph.matrix[3] = a3;
        graph.matrix[4] = a4;
        graph.matrix[5] = a5;
        graph.matrix[6] = a6;
        graph.matrix[7] = a7;
        graph.matrix[8] = a8;

        Utils.msg("\n图的深度优先遍历:  ");
        graph.depthFirstSearch();

        Utils.msg("\n图的广度优先遍历:  ");
        graph.broadFirstSearch();

        Utils.msg("\n普里姆算法:  ");
        graph.prim();
    }
}
