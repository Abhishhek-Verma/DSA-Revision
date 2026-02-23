1class Solution {
2    private List<List<Integer>> lst = new ArrayList<>();
3    public List<List<Integer>> combinationSum3(int k, int n) {
4        check(k, n, new ArrayList<>(), 0, 1);
5        return lst;
6    }
7    private  void check(int k, int n, List<Integer> ds, int sum, int num){
8        if(k == 0 && sum == n){
9            lst.add(new ArrayList<>(ds));
10            return;
11        }
12        if(k == 0 || sum > n || num > 9) return;
13
14        ds.add(num);
15        check(k-1, n, ds, sum+num, num+1);
16        ds.remove(ds.size()-1);
17        check(k, n, ds, sum, num+1);
18    }
19}