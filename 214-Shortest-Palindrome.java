class Solution {
    public String shortestPalindrome(String s) {
         String rev = new StringBuilder(s).reverse().toString();
        String str = s + "#" + rev;
        int[] lps = buildLPS(str);
        int longestPalPrefix = lps[str.length() - 1];
        String remain = s.substring(longestPalPrefix);
        return new StringBuilder(remain).reverse().toString() + s;
    }

    private int[] buildLPS(String str) {
        int[] lps = new int[str.length()];
        int len = 0;
        int i = 1;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}