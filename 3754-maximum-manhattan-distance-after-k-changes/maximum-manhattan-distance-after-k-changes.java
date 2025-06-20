class Solution {
    public int maxDistance(String s, int k) {
        int ans = 0, step = 0, longitude = 0, latitude = 0;
        for(char c : s.toCharArray()){
            if(c == 'N') latitude++;
            else if(c == 'S') latitude--;
            else if(c == 'E') longitude++;
            else if(c == 'W') longitude--;
            step++;

            ans = Math.max(ans, Math.min(Math.abs(latitude) + Math.abs(longitude) + k * 2, step));
        }
        return ans;
    }
}
