package leon.training.datastructure.imp;

import leon.training.utils.Utils;

/**
 * Created by leon on 2017/9/17.
 */

public class MGraphEdge {

    private Edge[] edges;
    private int edgeSize;

    public MGraphEdge(int edgeSize) {
        this.edgeSize = edgeSize;
        edges = new Edge[edgeSize];
    }

    public static MGraphEdge createEdgeArray() {
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
        MGraphEdge graph = new MGraphEdge(data.length);
        for (int i = 0; i < data.length; i++) {
            graph.edges[i] = new Edge(data[i][0], data[i][1], data[i][2]);
        }
        return graph;
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

        Utils.msg("\n创建图 ");
        MGraphEdge graph = createEdgeArray();


    }


}

