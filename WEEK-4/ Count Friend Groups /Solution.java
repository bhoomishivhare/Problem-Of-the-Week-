import java.util.*;

public class CountFriendGroups {

    // ---------------------------------------------------
    // Approach 1: DFS
    // ---------------------------------------------------
    // public static int countGroupsDFS(int N, Map<Integer, List<Integer>> friendship) {
    //     boolean[] visited = new boolean[N];
    //     int count = 0;

    //     for (int student = 0; student < N; student++) {
    //         if (!visited[student]) {
    //             dfs(student, friendship, visited);
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    // private static void dfs(int current, Map<Integer, List<Integer>> friendship, boolean[] visited) {
    //     visited[current] = true;
    //     List<Integer> friends = friendship.getOrDefault(current, Collections.emptyList());
    //     for (int friend : friends) {
    //         if (!visited[friend]) {
    //             dfs(friend, friendship, visited);
    //         }
    //     }
    // }

    // ---------------------------------------------------
    // Approach 2: BFS
    // ---------------------------------------------------
    // public static int countGroupsBFS(int N, Map<Integer, List<Integer>> friendship) {
    //     boolean[] visited = new boolean[N];
    //     int count = 0;

    //     for (int student = 0; student < N; student++) {
    //         if (!visited[student]) {
    //             bfs(student, friendship, visited);
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    // private static void bfs(int start, Map<Integer, List<Integer>> friendship, boolean[] visited) {
    //     Queue<Integer> queue = new LinkedList<>();
    //     queue.offer(start);
    //     visited[start] = true;

    //     while (!queue.isEmpty()) {
    //         int current = queue.poll();
    //         List<Integer> friends = friendship.getOrDefault(current, Collections.emptyList());
    //         for (int friend : friends) {
    //             if (!visited[friend]) {
    //                 visited[friend] = true;
    //                 queue.offer(friend);
    //             }
    //         }
    //     }
    // }

    // ---------------------------------------------------
    // Approach 3: Union-Find (Disjoint Set Union - DSU)
    // ---------------------------------------------------
    public static int countGroupsUnionFind(int N, Map<Integer, List<Integer>> friendship) {
        UnionFind uf = new UnionFind(N);

        for (int student = 0; student < N; student++) {
            List<Integer> friends = friendship.getOrDefault(student, Collections.emptyList());
            for (int friend : friends) {
                uf.union(student, friend);
            }
        }

        return uf.getCount();
    }

    static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                // Union by rank
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
