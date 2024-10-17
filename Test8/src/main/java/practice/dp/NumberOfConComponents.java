package practice.dp;

import java.util.HashSet;
import java.util.Set;

public class NumberOfConComponents {
    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {1, 2}, {3, 4}};
        int i = countComponents(5, arr);
        System.out.println(i);
    }

    public static int countComponents(int n, int[][] edges) {
        int[] ids = new int[n];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], ids);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < ids.length; i++) {
            set.add(find(i, ids));
        }
        return set.size();
    }

    public static void union(int edge1, int edge2, int[] ids) {
        int parent1 = find(edge1, ids);
        int parent2 = find(edge2, ids);
        ids[parent1] = parent2;
    }

    public static int find(int edge, int[] ids) {
        if (ids[edge] != edge) {
            ids[edge] = find(ids[edge], ids);
        }
        return ids[edge];
    }
}
