class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>>ans = new ArrayList<>();
        for(int i =0;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<=i;j++){
                temp.add(ncr(i,j));
            } 
            ans.add(temp);
        }
        return ans;
    }
    private int ncr(int n, int r){
        long res =1;
        for(int i=1;i<=r;i++){
           res = res * (n - i + 1) / i;
        }
        return  (int) res;
    }
}