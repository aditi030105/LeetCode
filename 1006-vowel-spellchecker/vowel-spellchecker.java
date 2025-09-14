class Solution {
    Set<String> exactWords = new HashSet<>();
    Map<String, String> caseMap = new HashMap<>();
    Map<String, String> vowelMap = new HashMap<>();

    private String toLower(String s) {
        return s.toLowerCase();
    }

    private String maskVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private String checkForMatch(String query) {
        if (exactWords.contains(query)) {
            return query;
        }

        String lowerQuery = toLower(query);
        if (caseMap.containsKey(lowerQuery)) {
            return caseMap.get(lowerQuery);
        }

        String maskedQuery = maskVowels(lowerQuery);
        if (vowelMap.containsKey(maskedQuery)) {
            return vowelMap.get(maskedQuery);
        }
        return "";
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        exactWords.clear();
        caseMap.clear();
        vowelMap.clear();

        for (String word : wordlist) {
            exactWords.add(word);

            String lowerWord = toLower(word);
            caseMap.putIfAbsent(lowerWord, word);

            String maskedWord = maskVowels(lowerWord);
            vowelMap.putIfAbsent(maskedWord, word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = checkForMatch(queries[i]);
        }
        return result;
    }
}