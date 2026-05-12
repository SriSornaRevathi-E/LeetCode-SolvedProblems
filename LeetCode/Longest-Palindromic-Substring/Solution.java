1class Solution {
2
3    public String longestPalindrome(String s) {
4
5        if(s == null || s.length() < 1)
6            return "";
7
8        String result = "";
9
10        for(int i = 0; i < s.length(); i++) {
11
12            // Odd length
13            String odd = expand(s, i, i);
14
15            // Even length
16            String even = expand(s, i, i + 1);
17
18            if(odd.length() > result.length()) {
19                result = odd;
20            }
21
22            if(even.length() > result.length()) {
23                result = even;
24            }
25        }
26
27        return result;
28    }
29
30    public String expand(String s, int left, int right) {
31
32        while(left >= 0 &&
33              right < s.length() &&
34              s.charAt(left) == s.charAt(right)) {
35
36            left--;
37            right++;
38        }
39
40        return s.substring(left + 1, right);
41    }
42}