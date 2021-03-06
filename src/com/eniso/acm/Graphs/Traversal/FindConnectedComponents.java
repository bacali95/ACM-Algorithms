package com.eniso.acm.Graphs.Traversal;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class FindConnectedComponents {

    public static int n;
    private static boolean[] visited = new boolean[100000];
    private static ArrayList<Integer>[] AdjList = new ArrayList[100000];

    private static void dfs(int u) {
        visited[u] = true;
        for (int i = 0; i < AdjList[u].size(); i++) {
            int v = AdjList[u].get(i);
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        int n = 9;
        for (int i = 0; i < n; i++) {
            AdjList[i] = new ArrayList<>();
        }
        AdjList[0].add(1);
        AdjList[1].add(0);
        AdjList[1].add(2);
        AdjList[1].add(3);
        AdjList[2].add(1);
        AdjList[2].add(3);
        AdjList[3].add(1);
        AdjList[3].add(2);
        AdjList[3].add(4);
        AdjList[4].add(3);
        AdjList[6].add(7);
        AdjList[6].add(8);
        AdjList[7].add(6);
        AdjList[8].add(6);
        int numCC = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ++numCC;
                dfs(i);
            }
        }
        out.println(numCC);
        out.close();
    }
}
