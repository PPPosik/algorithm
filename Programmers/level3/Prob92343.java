package Programmers.level3;

public class Prob92343 {
    public int solution(int[] info, int[][] edges) {
        int[][] tree = new int[info.length][3];
        boolean[] canVisit = new boolean[info.length];

        for (int i = 0; i < tree.length; i++) {
            tree[i][0] = -1;
            tree[i][1] = -1;
            tree[i][2] = info[i];
        }

        for (int[] edge : edges) {
            if (tree[edge[0]][0] == -1) {
                tree[edge[0]][0] = edge[1];
            } else {
                tree[edge[0]][1] = edge[1];
            }
        }

        return dfs(tree, canVisit, 0, 1, 0);
    }

    private int dfs(int[][] tree, boolean[] canVisit, int node, int sheep, int wolf) {
        if(tree[node][0] == -1 && tree[node][1] == -1) {
            return sheep;
        }
        
        if (tree[node][0] != -1) {
            canVisit[tree[node][0]] = true;
        }
        if (tree[node][1] != -1) {
            canVisit[tree[node][1]] = true;
        }

        System.out.print(node + "(" + sheep + ", " + wolf + ") : ");
        for(int i = 0; i < canVisit.length; i++) {
            if(canVisit[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        int ret = sheep;
        for (int i = 0; i < canVisit.length; i++) {
            if (canVisit[i]) {
                if (tree[i][2] == 1 && sheep > wolf + 1) {
                    canVisit[i] = false;
                    ret = Math.max(ret, dfs(tree, canVisit, i, sheep, wolf + 1));
                    canVisit[i] = true;
                } else if (tree[i][2] == 0) {
                    System.out.println(node + " -> " + i);
                    canVisit[i] = false;
                    // 6 7 방문하면 양을 데려와야함
                    ret = Math.max(ret, dfs(tree, canVisit, i, sheep + 1, wolf));
                    canVisit[i] = true;
                }
            }
        }

        return ret;
    }
}
