package practice.graph.ex01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 无向图，邻接表存储
 * @Created by XP
 * @Date 2019/7/8
 */
public class Graph {

    private int vertex;//顶点数
    private LinkedList<Integer>[] edgeList;//邻接表

    public Graph(int vertex) {
        this.vertex = vertex;
        edgeList = new LinkedList[vertex];
        for (int i = 0; i < edgeList.length; i++) {
            edgeList[i] = new LinkedList<>();
        }
    }

    /**
     * 添加边集
     *
     * @param start
     * @param end
     */
    public void addEdge(int start, int end) {
        if (start < vertex && start >= 0 && end < vertex && end >= 0) {
            edgeList[start].add(end);
            edgeList[end].add(start);
        }

    }

    /**
     * 广度优先搜索
     *
     * @param start 开始顶点
     * @param end   结束顶点
     */
    public void BFSearch(int start, int end) {
        if (start == end) return;
        //记录顶点是否访问临时数组
        boolean[] visited = new boolean[vertex];
        visited[start] = true;
        //存储已经被访问、但相连的顶点还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        //记录搜索路径临时数组
        int[] path = new int[vertex];
        for (int i = 0; i < path.length; i++) {
            path[i] = -1;//初始为-1，标识未访问
        }
        while (queue.size() != 0) {
            Integer present = queue.poll();
            for (int i = 0; i < edgeList[present].size(); i++) {
                Integer next = edgeList[present].get(i);
                if (!visited[next]) {
                    path[next] = present;
                    if (next == end) {
                        //打印搜索路径
                        print(path, start, end);
                        return;
                    }
                    visited[next] = true;
                    queue.add(next);
                }
            }

        }
    }

    /**
     * 深度优先搜索
     *
     * @param start
     * @param end
     */

    public void DFSearch(int start, int end) {
        //记录顶点是否访问临时数组
        boolean[] visited = new boolean[vertex];
        visited[start] = true;
        //记录搜索路径临时数组
        int[] path = new int[vertex];
        for (int i = 0; i < path.length; i++) {
            path[i] = -1;//初始为-1，标识未访问
        }
        dfs(start, end, visited, path);
        print(path, start, end);
    }

    private static boolean found = false;

    private void dfs(int start, int end, boolean[] visited, int[] path) {
        if (found == true) return;
        visited[start] = true;
        if (start == end) {
            found = true;
            return;
        }
        for (int i = 0; i < edgeList[start].size(); i++) {
            int next = edgeList[start].get(i);
            if (!visited[next]) {
                path[next] = start;
                dfs(next, end, visited, path);
            }
        }

    }


    private void print(int[] path, int start, int end) {
        if (path[end] != -1 && start != end) {
            print(path, start, path[end]);
        }
        System.out.print(end + " ");
    }

}
