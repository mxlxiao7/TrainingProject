package leon.training.datastructure.imp;

import leon.training.utils.Utils;

/**
 * Created by leon on 2017/9/18.
 */

public class MGraphDijstra {
    private static final int MAX_WEIGHT = 65535;
    private int vertexSize;//顶点数量
    public int[][] matrix;
    public int[] shortPath;//记录v0到某顶点的最短路径和


    public MGraphDijstra(int vertexSize) {
        this.vertexSize = vertexSize;
        matrix = new int[vertexSize][vertexSize];
        shortPath = new int[vertexSize];
    }


    public void dijstra() {
        //判断是否找到最小路径
        boolean[] isGetPath = new boolean[vertexSize];

        //初始化
        for (int i = 0; i < vertexSize; i++) {
            shortPath[i] = matrix[0][i];
        }

        //因为第一个v0->v0的距离不用找，就是最短距离，所以直接为0
        shortPath[0] = 0;
        isGetPath[0] = true;


        for (int v = 1; v < vertexSize; v++) {
            int k = 0; //标记下标
            int min = MAX_WEIGHT;
            for (int w = 0; w < vertexSize; w++) {
                if (!isGetPath[w] && shortPath[w] < min) {
                    k = w;
                    min = shortPath[w];
                }
            }
            isGetPath[k] = true;
            //从相应的顶点出发
            for (int j = 0; j < vertexSize; j++) {
                if (!isGetPath[j] && (min + matrix[k][j]) < shortPath[j]) {
                    shortPath[j] = min + matrix[k][j];
                }
            }

        }

        for (int i = 0; i < shortPath.length; i++) {
            Utils.msg("V0 到 V" + i + " 最短路径 ： " + shortPath[i]);
        }
    }


    /********************************测试 start*********************************/
    public static void main() {
        MGraphDijstra graph = new MGraphDijstra(9);
        int[] a0 = new int[]{0, 1, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a1 = new int[]{1, 0, 3, 7, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a2 = new int[]{5, 0, 3, MAX_WEIGHT, 1, 7, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a3 = new int[]{MAX_WEIGHT, 7, MAX_WEIGHT, 0, 2, MAX_WEIGHT, 3, MAX_WEIGHT, MAX_WEIGHT};
        int[] a4 = new int[]{MAX_WEIGHT, 5, 1, 2, 0, 3, 6, 9, MAX_WEIGHT};
        int[] a5 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 7, MAX_WEIGHT, 3, 0, MAX_WEIGHT, 5, MAX_WEIGHT};
        int[] a6 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 3, 6, MAX_WEIGHT, 0, 2, 7};
        int[] a7 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 9, 5, 2, 0, 4};
        int[] a8 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 7, 4, 0};
        graph.matrix[0] = a0;
        graph.matrix[1] = a1;
        graph.matrix[2] = a2;
        graph.matrix[3] = a3;
        graph.matrix[4] = a4;
        graph.matrix[5] = a5;
        graph.matrix[6] = a6;
        graph.matrix[7] = a7;
        graph.matrix[8] = a8;
        Utils.msg("\n迪杰斯特拉算法:  ");
        graph.dijstra();
    }


}
