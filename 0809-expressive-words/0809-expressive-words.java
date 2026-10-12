class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;

        for (String word : words) {
            if (isStretchy(s, word)) {
                count++;
            }
        }

        return count;
    }

    private boolean isStretchy(String s, String word) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < word.length()) {
            // Characters must match
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }

            // Count same characters in s
            int startI = i;
            while (i < s.length() && s.charAt(i) == s.charAt(startI)) {
                i++;
            }
            int countS = i - startI;

            // Count same characters in word
            int startJ = j;
            while (j < word.length() && word.charAt(j) == word.charAt(startJ)) {
                j++;
            }
            int countWord = j - startJ;

            // Check whether this group can be stretched
            if (countS < countWord) {
                return false;
            }

            if (countS != countWord && countS < 3) {
                return false;
            }
        }

        // Both strings must be completely processed
        return i == s.length() && j == word.length();
    }
}
