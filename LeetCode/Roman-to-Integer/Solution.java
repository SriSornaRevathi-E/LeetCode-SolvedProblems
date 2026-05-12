1class Solution {
2
3    public int romanToInt(String s) {
4        int total = 0;
5        for(int i = 0; i < s.length(); i++) {
6            int current = value(s.charAt(i));
7            // Check next character
8            if(i < s.length() - 1 &&
9               current < value(s.charAt(i + 1))) {
10
11                total -= current;
12
13            } else {
14
15                total += current;
16            }
17        }
18
19        return total;
20    }
21    public int value(char c) {
22        if(c == 'I') return 1;
23        if(c == 'V') return 5;
24        if(c == 'X') return 10;
25        if(c == 'L') return 50;
26        if(c == 'C') return 100;
27        if(c == 'D') return 500;
28        return 1000;
29    }
30}