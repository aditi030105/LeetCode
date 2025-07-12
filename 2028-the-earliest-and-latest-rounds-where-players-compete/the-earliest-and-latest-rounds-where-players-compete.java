class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        return dfs(n, firstPlayer, secondPlayer, 1);
    }
    private int[] dfs(int n, int playerA, int playerB, int round){
        if(playerA + playerB == n + 1){
            return new int[]{round, round};
        }
        int minRound = Integer.MAX_VALUE;
        int maxRound = Integer.MIN_VALUE;
        int totalPairs = n / 2;
        boolean hasMiddle = (n % 2 == 1);

        List<Integer> advancingPlayers = new ArrayList<>();

        for(int mask = 0; mask < (1 << totalPairs); mask++){
            Set<Integer> nextRound = new TreeSet<>();
            boolean includeA = false, includeB = false;

            for(int i = 0; i < totalPairs; i++){
                int left = i + 1;
                int right = n - i;
                int winner;
                if((mask & (1 << i)) != 0){
                    winner = left;
                }else{
                    winner = right;
                }
                nextRound.add(winner);
                if(winner == playerA) includeA = true;
                if(winner == playerB) includeB = true;
            }
            if(hasMiddle){
                int middle = (n / 2) + 1;
                nextRound.add(middle);
                if(middle == playerA) includeA = true;
                if(middle == playerB) includeB = true;
            }
            if(includeA && includeB){
                List<Integer> list = new ArrayList<>(nextRound);
                int newIndexA = list.indexOf(playerA) + 1;
                int newIndexB = list.indexOf(playerB) + 1;
                int[] res = dfs(list.size(), newIndexA, newIndexB, round + 1);
                minRound = Math.min(minRound, res[0]);
                maxRound = Math.max(maxRound, res[1]);
            }
        }
        int[] result = new int[]{minRound, maxRound};
        return result;
    }
}