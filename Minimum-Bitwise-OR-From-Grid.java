1class Solution {
2    public int minimumOR(int[][] grid) {
3        int res = (1<<30)-1;
4        for(int k = 29;k>=0;k--){
5            int temp = res^(1<<k);
6           boolean done = true;
7            for(int i =0;i<grid.length;i++){
8                boolean fnd = false;
9
10                for(int j =0;j<grid[i].length;j++){
11                    if((grid[i][j]| temp)== temp){
12                        fnd = true;
13                        break;
14                    }
15                }
16                if(!fnd){
17                    done = false;
18                    break;
19                }
20            }
21            if(done){
22                res = temp;
23            }
24        }
25        return res;
26    }
27}