1class Solution {
2    public int minimumTimeRequired(int[] jobs, int k) {
3        Arrays.sort(jobs);
4        reverse(jobs); // important optimization
5        int low = jobs[0]; // max job
6        int high = 0;
7        for (int job : jobs) high += job;
8        int ans = high;
9        while (low <= high) {
10            int mid = (low + high) / 2;
11            int[] workers = new int[k];
12            if (canAssign(jobs, workers, 0, mid)) {
13                ans = mid;
14                high = mid - 1;
15            } else {
16                low = mid + 1;
17            }
18        }
19        return ans;
20    }
21    private boolean canAssign(int[] jobs, int[] workers, int idx, int limit) {
22        if (idx == jobs.length) return true;
23        for (int i = 0; i < workers.length; i++) {
24            if (workers[i] + jobs[idx] <= limit) {
25                workers[i] += jobs[idx];
26                if (canAssign(jobs, workers, idx + 1, limit)) return true;
27                workers[i] -= jobs[idx];
28            }
29            // 🔥 Pruning 1: same state skip
30            if (workers[i] == 0) break;
31        }
32        return false;
33    }
34    private void reverse(int[] arr) {
35        int i = 0, j = arr.length - 1;
36        while (i < j) {
37            int temp = arr[i];
38            arr[i++] = arr[j];
39            arr[j--] = temp;
40        }
41    }
42}