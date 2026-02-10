1class Solution {
2    public int findMaxLength(int[] arr) {
3        for(int i=0;i<arr.length;i++){
4            if(arr[i]==0){
5                arr[i]=-1;
6            }
7        }
8        HashMap<Integer, Integer> map = new HashMap<>();
9        int sum = 0, max = 0;
10        for (int i = 0; i < arr.length; i++) {
11            sum += arr[i];
12            if (sum == 0)
13                max = i + 1;
14            if (map.containsKey(sum))
15                max = Math.max(max, i - map.get(sum));
16            else
17                map.put(sum, i);
18        }
19        return max;
20    }
21}