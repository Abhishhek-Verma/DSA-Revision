1import java.util.Stack;
2
3class MyQueue {
4    private Stack<Integer> s1;
5    private Stack<Integer> s2;
6    
7    public MyQueue() {
8        s1 = new Stack<>();
9        s2 = new Stack<>();
10    }
11    
12    public void push(int x) {
13        while (!s1.isEmpty()) {
14            s2.push(s1.pop());
15        }
16        s1.push(x);
17        while (!s2.isEmpty()) {
18            s1.push(s2.pop());
19        }
20    }
21    public int pop() {
22        if (s1.isEmpty()) {
23            return -1;
24        }
25        return s1.pop();
26    }
27    
28    public int peek() {
29        if (s1.isEmpty()) {
30            return -1;
31        }
32        return s1.peek();
33    }
34    
35    public boolean empty() {
36        return s1.isEmpty();
37    }
38}
39
40/**
41 * Your MyQueue object will be instantiated and called as such:
42 * MyQueue obj = new MyQueue();
43 * obj.push(x);
44 * int param_2 = obj.pop();
45 * int param_3 = obj.peek();
46 * boolean param_4 = obj.empty();
47 */