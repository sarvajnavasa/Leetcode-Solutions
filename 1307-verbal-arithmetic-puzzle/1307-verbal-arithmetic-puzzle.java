class Solution {
    int[] map = new int[26];
    boolean[] used = new boolean[10];
    boolean[] leading = new boolean[26];

    public boolean isSolvable(String[] words, String result) {
        java.util.Arrays.fill(map, -1);

        for (String word : words) {
            if (word.length() > result.length())
                return false;

            if (word.length() > 1)
                leading[word.charAt(0) - 'A'] = true;
        }

        if (result.length() > 1)
            leading[result.charAt(0) - 'A'] = true;

        return dfs(words, result, 0, 0, 0);
    }

    boolean dfs(String[] words, String result, int col, int row, int sum) {
        if (col == result.length())
            return sum == 0;

        if (row == words.length) {
            int digit = sum % 10;
            int carry = sum / 10;

            char c = result.charAt(result.length() - 1 - col);
            int idx = c - 'A';

            if (map[idx] != -1) {
                if (map[idx] != digit)
                    return false;

                return dfs(words, result, col + 1, 0, carry);
            }

            if (used[digit])
                return false;

            if (digit == 0 && leading[idx])
                return false;

            map[idx] = digit;
            used[digit] = true;

            if (dfs(words, result, col + 1, 0, carry))
                return true;

            map[idx] = -1;
            used[digit] = false;

            return false;
        }

        if (col >= words[row].length())
            return dfs(words, result, col, row + 1, sum);

        char c = words[row].charAt(words[row].length() - 1 - col);
        int idx = c - 'A';

        if (map[idx] != -1)
            return dfs(words, result, col, row + 1, sum + map[idx]);

        for (int digit = 0; digit <= 9; digit++) {
            if (used[digit])
                continue;

            if (digit == 0 && leading[idx])
                continue;

            map[idx] = digit;
            used[digit] = true;

            if (dfs(words, result, col, row + 1, sum + digit))
                return true;

            map[idx] = -1;
            used[digit] = false;
        }

        return false;
    }
}