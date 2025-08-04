class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> fruitMap = new HashMap<>();

        int i = 0;
        int j = 0;
        int count = 0;

        while (j < n) {
            fruitMap.put(fruits[j], fruitMap.getOrDefault(fruits[j], 0) + 1);

            if (fruitMap.size() > 2) {
                fruitMap.put(fruits[i], fruitMap.get(fruits[i]) - 1);
                if (fruitMap.get(fruits[i]) == 0) {
                    fruitMap.remove(fruits[i]);
                }
                i++;
            }
            count = Math.max(count, j - i + 1);
            j++;
        }
        return count;
    }
}