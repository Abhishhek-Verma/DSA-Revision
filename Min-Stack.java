1class MinStack {
2	private Node head;
3    public void push(int x) {
4        if (head == null) 
5            head = new Node(x, x, null);
6        else 
7            head = new Node(x, Math.min(x, head.min), head);
8    }
9    public void pop() {
10        head = head.next;
11    }
12    public int top() {
13        return head.val;
14    }
15    public int getMin() {
16        return head.min;
17    }  
18    private class Node {
19        int val;
20        int min;
21        Node next; 
22        private Node(int val, int min, Node next) {
23            this.val = val;
24            this.min = min;
25            this.next = next;
26        }
27    }
28}