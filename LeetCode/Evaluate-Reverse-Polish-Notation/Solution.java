1class Solution {
2    public int evalRPN(String[] tokens) {
3        ArrayList<String> list = new ArrayList<>();
4        for (String token : tokens) {
5            list.add(token);
6        }
7        while (list.size() > 1) {
8            for (int i = 0; i < list.size(); i++) {
9                String token = list.get(i);
10                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
11                    int a = Integer.parseInt(list.get(i - 2));
12                    int b = Integer.parseInt(list.get(i - 1));
13                    int res = 0;
14                    switch (token) {
15                        case "+":
16                            res = a + b; break;
17                        case "-":
18                            res = a - b; break;
19                        case "*":
20                            res = a * b; break;
21                        case "/":
22                            res = a / b; break;
23                    }
24                    list.remove(i);
25                    list.remove(i - 1); 
26                    list.remove(i - 2); 
27                    list.add(i - 2, String.valueOf(res));
28                    break; 
29                }
30            }
31        }
32        return Integer.parseInt(list.get(0));
33    }
34    public static void main(String[] args) {
35        Solution sol = new Solution();
36        String[] tokens = {"2","1","+","3","*"};
37        System.out.println(sol.evalRPN(tokens)); 
38    }
39}