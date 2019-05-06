package com.guava.test;

import com.google.common.collect.Lists;
import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.Graphs;
import com.google.common.graph.MutableGraph;
import lombok.ToString;

import java.util.*;

/**
 * @author : fengyuchen
 * @discription :
 * @date : created on 2019-02-26 15:02
 * @modified :
 **/
public class GraphTest {

    public static void main(String[] args) {
        Graph <Node> graph = GraphBuilder.directed().build();


        List<Node> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Node n = new Node(String.valueOf(i),i);
            ((MutableGraph<Node>) graph).addNode(n);
            list.add(n);
        }

        ((MutableGraph<Node>) graph).putEdge(list.get(0),list.get(1));
        ((MutableGraph<Node>) graph).putEdge(list.get(0),list.get(2));
        ((MutableGraph<Node>) graph).putEdge(list.get(1),list.get(3));
        ((MutableGraph<Node>) graph).putEdge(list.get(1),list.get(4));
        ((MutableGraph<Node>) graph).putEdge(list.get(2),list.get(4));
        ((MutableGraph<Node>) graph).putEdge(list.get(4),list.get(5));
        ((MutableGraph<Node>) graph).putEdge(list.get(3),list.get(5));


        Map<Node, Boolean> visited = new HashMap<>();
        List<List<Node>> allPaths = new ArrayList<>();
        List<Node> temp = new ArrayList<>();

        dfs(graph,list.get(0),list.get(5),visited,allPaths,temp);


        for (List<Node> allPath : allPaths) {
            System.out.println(allPath);
        }



    }

    /**
     * 回溯法dfs
     */
    private static  void dfsFindPaths(Graph<Node> graph, Node cur, Node dest, Map<Node, Boolean> visited,
                     List<List<Node>> allPaths, List<Node> temp){
        visited.put(cur, true);
        temp.add(cur);
        if (cur.getNum() == dest.getNum()){
            allPaths.add(Lists.newArrayList(temp.iterator()));
        }else {
            for (Node next : graph.successors(cur)){
                if (visited.get(next) == null || !visited.get(next))
                    dfsFindPaths(graph, next, dest, visited, allPaths, temp);
            }
        }
        visited.put(cur, false);
        temp.remove(temp.size() - 1);
    }


    private static void dfs(Graph<Node> graph, Node cur, Node dest, Map<Node, Boolean> visited,
                            List<List<Node>> allPaths, List<Node> temp){
        visited.put(cur,true);
        temp.add(cur);
        System.out.println("访问 " + cur);
            for (Node successor : graph.successors(cur)) {
                if (visited.get(successor) == null || !visited.get(successor))
                    dfs(graph, successor, dest, visited, allPaths, temp);
            }
        temp.remove(temp.size() - 1);
    }

    private static void dfsNoRecur(Graph<Node> graph, Node cur, Node dest, Map<Node, Boolean> visited,
                                    List<List<Node>> allPaths, List<Node> temp){
        Stack<Node> stack = new Stack<>();
        Node x = cur;
        stack.push(x);
        while (!stack.isEmpty()){
            Node next = graph.successors(stack.peek()).iterator().next();
            if (visited.get(next) == null || !visited.get(next)){
                visited.put(next,true);
                stack.push(next);
            } else {
                x = stack.peek();
            }
        }






    }

    @ToString
    static class Node{
        public Node(String s, int i) {
            this.value = s;
            this.num = i;
        }



        String value;

        int num;


        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
