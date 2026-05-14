1class Solution {
2    public int climbStairs(int n) {
3        if(n<=1)return 1;
4        int num1=1;
5        int num2=2;
6        for(int i=3;i<=n;i++){
7            int temp=num1+num2;
8            num1=num2;
9            num2=temp;
10        }
11        return num2;
12    }
13}