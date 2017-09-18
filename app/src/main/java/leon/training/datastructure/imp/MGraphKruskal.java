package leon.training.datastructure.imp;

import leon.training.utils.Utils;

/**
 * Created by leon on 2017/9/17.
 */

public class MGraphKruskal {

    private Edge[] edges;
    private int edgeSize;

    public MGraphKruskal(int edgeSize) {
        this.edgeSize = edgeSize;
        edges = new Edge[edgeSize];
    }

    public static MGraphKruskal createEdgeArray() {
        int[][] data = {
                {4, 7, 7},
                {2, 8, 8},
                {0, 1, 10},
                {0, 5, 11},
                {1, 8, 12},
                {3, 7, 16},
                {1, 6, 16},
                {5, 6, 17},
                {1, 2, 18},
                {6, 7, 19},
                {3, 4, 20},
                {3, 8, 21},
                {2, 3, 22},
                {3, 6, 24},
                {4, 5, 26},
        };
        MGraphKruskal graph = new MGraphKruskal(data.length);
        for (int i = 0; i < data.length; i++) {
            graph.edges[i] = new Edge(data[i][0], data[i][1], data[i][2]);
        }
        return graph;
    }



    /**
     * 克鲁斯卡尔算法
     */
    public void miniSpan() {
        int m, n, sum = 0;
        //下标为起点，数值为终点
        //parent[4] = 7 代表起点为4，终点为7的边
        int[] parent = new int[edgeSize];

        for (int i = 0; i < edgeSize; i++) {
            parent[i] = 0;
        }

        for (int i = 0; i < edgeSize; i++) {
            n = find(parent, edges[i].begin);
            m = find(parent, edges[i].end);

            if (n != m) {
                parent[n] = m;
                Utils.msg("起始顶点: " + edges[i].begin + " 结束顶点： " + edges[i].end + " 权值： " + edges[i].weight);
                sum += edges[i].weight;
            }
        }
        Utils.msg("最小生成树权值和： " + sum);
    }

    /**
     * 将数组进行查询，获取非回环的值
     *
     * @param parent
     * @param end
     * @return
     */
    private int find(int[] parent, int f) {
        while (parent[f] > 0) {
            f = parent[f];
        }
        return f;
    }





    private static class Edge {
        public int begin;
        public int end;
        public int weight;

        public Edge() {

        }

        public Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }
    }


    /********************************测试 start*********************************/
    public static void main() {

        Utils.msg("\n克鲁斯卡尔算法:  ");
        MGraphKruskal graph = createEdgeArray();
        graph.miniSpan();

    }
}

