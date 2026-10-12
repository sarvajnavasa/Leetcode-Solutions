class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        // pattern -> word
        int[] map1 = new int[26];

        // word -> pattern
        int[] map2 = new int[26];

        Arrays.fill(map1, -1);
        Arrays.fill(map2, -1);

        for (int i = 0; i < word.length(); i++) {
            int w = word.charAt(i) - 'a';
            int p = pattern.charAt(i) - 'a';

            // Existing mappings must be consistent
            if (map1[p] != -1 && map1[p] != w) {
                return false;
            }

            if (map2[w] != -1 && map2[w] != p) {
                return false;
            }

            map1[p] = w;
            map2[w] = p;
        }

        return true;
    }
}
