1class Solution {
2    private static List<List<Integer>> lst = new ArrayList<>();
3    public List<List<Integer>> combinationSum3(int k, int n) {
4        lst.clear();
5        check(k, n, new ArrayList<>(), 0, 1);
6        return lst;
7    }
8    private static void check(int k, int n, List<Integer> ds, int sum, int num){
9        if(k == 0 && sum == n){
10            lst.add(new ArrayList<>(ds));
11            return;
12        }
13        if(k == 0 || sum > n || num > 9) return;
14
15        ds.add(num);
16        check(k-1, n, ds, sum+num, num+1);
17        ds.remove(ds.size()-1);
18        check(k, n, ds, sum, num+1);
19    }
20}