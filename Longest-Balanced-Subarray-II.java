1//not done by me 
2class Solution {
3
4    static class Node {
5        int l, r;
6        int mn, mx;
7        int lazy;
8    }
9
10    static class SegmentTree {
11        Node[] tr;
12
13        SegmentTree(int n) {
14            tr = new Node[n << 2];
15            for (int i = 0; i < tr.length; i++) {
16                tr[i] = new Node();
17            }
18            build(1, 0, n);
19        }
20
21        void build(int u, int l, int r) {
22            tr[u].l = l;
23            tr[u].r = r;
24            tr[u].mn = tr[u].mx = 0;
25            tr[u].lazy = 0;
26            if (l == r) return;
27            int mid = (l + r) >> 1;
28            build(u << 1, l, mid);
29            build(u << 1 | 1, mid + 1, r);
30        }
31
32        void modify(int u, int l, int r, int v) {
33            if (tr[u].l >= l && tr[u].r <= r) {
34                apply(u, v);
35                return;
36            }
37            pushdown(u);
38            int mid = (tr[u].l + tr[u].r) >> 1;
39            if (l <= mid) modify(u << 1, l, r, v);
40            if (r > mid) modify(u << 1 | 1, l, r, v);
41            pushup(u);
42        }
43
44        int query(int u, int target) {
45            if (tr[u].l == tr[u].r) {
46                return tr[u].l;
47            }
48            pushdown(u);
49            int left = u << 1;
50            int right = u << 1 | 1;
51            if (tr[left].mn <= target && target <= tr[left].mx) {
52                return query(left, target);
53            }
54            return query(right, target);
55        }
56
57        void apply(int u, int v) {
58            tr[u].mn += v;
59            tr[u].mx += v;
60            tr[u].lazy += v;
61        }
62
63        void pushup(int u) {
64            tr[u].mn = Math.min(tr[u << 1].mn, tr[u << 1 | 1].mn);
65            tr[u].mx = Math.max(tr[u << 1].mx, tr[u << 1 | 1].mx);
66        }
67
68        void pushdown(int u) {
69            if (tr[u].lazy != 0) {
70                apply(u << 1, tr[u].lazy);
71                apply(u << 1 | 1, tr[u].lazy);
72                tr[u].lazy = 0;
73            }
74        }
75    }
76
77    public int longestBalanced(int[] nums) {
78        int n = nums.length;
79        SegmentTree st = new SegmentTree(n);
80        Map<Integer, Integer> last = new HashMap<>();
81        int now = 0;
82        int ans = 0;
83
84        for (int i = 1; i <= n; i++) {
85            int x = nums[i - 1];
86            int det = (x & 1) == 1 ? 1 : -1;
87
88            if (last.containsKey(x)) {
89                st.modify(1, last.get(x), n, -det);
90                now -= det;
91            }
92
93            last.put(x, i);
94            st.modify(1, i, n, det);
95            now += det;
96
97            int pos = st.query(1, now);
98            ans = Math.max(ans, i - pos);
99        }
100
101        return ans;
102    }
103}