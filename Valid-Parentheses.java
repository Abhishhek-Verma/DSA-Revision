1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> stack = new Stack<>();
4        for (char c : s.toCharArray()) {
5            if (c == '(' || c == '{' || c == '[') {
6                stack.push(c);
7            } else {
8                if (stack.isEmpty()) return false;
9                char top = stack.pop();
10                if ((c == ')' && top != '(') || 
11                    (c == '}' && top != '{') || 
12                    (c == ']' && top != '[')) {
13                    return false;
14                }
15            }
16        }
17        return stack.isEmpty();
18    }
19}