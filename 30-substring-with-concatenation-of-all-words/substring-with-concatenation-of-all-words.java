class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length(), numWords = words.length;
        int substringSize = wordLen * numWords;
        if (s.length() < substringSize) return result;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> currentCount = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String w = s.substring(right, right + wordLen);
                if (!wordCount.containsKey(w)) {
                    currentCount.clear();
                    count = 0;
                    left = right + wordLen;
                } else {
                    currentCount.put(w, currentCount.getOrDefault(w, 0) + 1);
                    count++;

                    while (currentCount.get(w) > wordCount.get(w)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == numWords) {
                        result.add(left);
                    }
                }
            }
        }

        return result;
    }
}
