1class StockSpanner {
2    Stack<int[]> s;
3
4    public StockSpanner() {
5        s = new Stack<>();
6
7    }
8
9    public int next(int price) {
10        int cnt = 1;
11        while (!s.isEmpty() && price >= s.peek()[0]) {
12            cnt += s.peek()[1];
13            s.pop();
14        }
15        s.push(new int[] { price, cnt });
16        return cnt;
17    }
18}
19
20/**
21 * Your StockSpanner object will be instantiated and called as such:
22 * StockSpanner obj = new StockSpanner();
23 * int param_1 = obj.next(price);
24 */