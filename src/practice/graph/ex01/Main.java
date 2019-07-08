package practice.graph.ex01;

/**
 * @author xp
 * @Describe 无向图测试
 * @create 2019-07-08
 */
public class Main {

    public static void main(String[] args) {
        Graph g = new  Graph(8);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(1,2);
        g.addEdge(1,4);
        g.addEdge(2,5);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.addEdge(5,7);
        g.addEdge(6,7);
        System.out.println("----广度优先搜索-----");
        g.BFSearch(0,7);
        System.out.println("\n----深度优先搜索-----");
        g.DFSearch(0,4);
    }
}
