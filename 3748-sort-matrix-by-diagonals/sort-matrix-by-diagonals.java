class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int diag = i - j;
                mp.computeIfAbsent(diag, k -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
            List<Integer> list = entry.getValue();
            if (entry.getKey() >= 0) {
                Collections.sort(list);
            } else {
                list.sort(Collections.reverseOrder());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int diag = i - j;
                List<Integer> list = mp.get(diag);
                grid[i][j] = list.remove(list.size() - 1);
            }
        }

        return grid;
    }
}