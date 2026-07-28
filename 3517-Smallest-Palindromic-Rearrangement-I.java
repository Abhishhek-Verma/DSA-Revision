class Solution {
    public String smallestPalindrome(String s) {
       int n = s.length();
        if (n % 2 == 0) {
            char[] f = s.substring(0, n / 2).toCharArray();
            Arrays.sort(f);
            String l = new String(f);
            String r = new StringBuilder(l).reverse().toString();
            return l + r;
        } else {
            char[] f = s.substring(0, n / 2).toCharArray();
            Arrays.sort(f);
            String l = new String(f);
            char m = s.charAt(n / 2);
            String r = new StringBuilder(l).reverse().toString();
            return l + m + r;
        }
    }
}