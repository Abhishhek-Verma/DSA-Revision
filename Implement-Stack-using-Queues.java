1class MyStack {
2    private Queue<Integer> q;
3    public MyStack() {
4        q= new LinkedList<>();
5    }
6    public void push(int x) {
7        q.add(x);
8        for(int i=0;i<q.size()-1;i++)
9        q.add(q.poll());
10    }
11    public int pop() {
12        return q.poll();
13    }
14    public int top() {
15        return q.peek();
16    }
17    public boolean empty() {
18        return q.isEmpty();
19    }
20}
21