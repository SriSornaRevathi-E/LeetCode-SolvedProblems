1class Solution {
2
3    public int finalPositionOfSnake(int n,
4                                    List<String> commands) {
5
6        int position = 0;
7
8        for(String cmd : commands) {
9
10            if(cmd.equals("RIGHT")) {
11                position += 1;
12            }
13
14            else if(cmd.equals("LEFT")) {
15                position -= 1;
16            }
17
18            else if(cmd.equals("DOWN")) {
19                position += n;
20            }
21
22            else {
23                position -= n;
24            }
25        }
26
27        return position;
28    }
29}