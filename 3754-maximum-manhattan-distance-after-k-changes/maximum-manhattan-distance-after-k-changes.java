class Solution {
    public int maxDistance(String s, int k) {
        int ans = 0;

        for (char hor : new char[]{'E', 'W'}) {
            for (char ver : new char[]{'N', 'S'}) {
                int remainingK = k;
                int netX = 0, netY = 0;

                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);

                    if (remainingK > 0 && (ch == hor)) {
                        ch = (ch == 'W') ? 'E' : 'W';
                        remainingK--;
                    }
                    else if (remainingK > 0 && (ch == ver)) {
                        ch = (ch == 'N') ? 'S' : 'N';
                        remainingK--;
                    }

                    switch (ch) {
                        case 'E': netX++; break;
                        case 'W': netX--; break;
                        case 'N': netY++; break;
                        case 'S': netY--; break;
                    }

                    ans = Math.max(ans, Math.abs(netX) + Math.abs(netY));
                }
            }
        }

        return ans;
    }
}
