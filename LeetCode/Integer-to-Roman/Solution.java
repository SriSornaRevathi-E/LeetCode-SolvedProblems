1class Solution {
2    public String intToRoman(int num) {
3        int[] values = {
4            1000, 900, 500, 400,
5            100, 90, 50, 40,
6            10, 9, 5, 4, 1
7        };
8        String[] romans = {
9            "M", "CM", "D", "CD",
10            "C", "XC", "L", "XL",
11            "X", "IX", "V", "IV", "I"
12        };
13        StringBuilder result = new StringBuilder();
14        for(int i = 0; i < values.length; i++) {
15            while(num >= values[i]) {
16                result.append(romans[i]);
17                num -= values[i];
18            }
19        }
20        return result.toString();
21    }
22}