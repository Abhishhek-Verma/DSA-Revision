1class Solution {
2    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
3        int n = bulbs.size();
4        List<Integer> lst = new ArrayList<>();
5        boolean[] arr = new boolean[101];
6        for (int x : bulbs) {
7            arr[x] = !arr[x];
8        }
9        for (int i = 0; i <= 100; i++) {
10            if (arr[i])
11                lst.add(i);
12        }
13        return lst;
14    }
15}