1class Solution {
2    public int bitwiseComplement(int n) {
3        int bits = 32 - Integer.numberOfLeadingZeros(n | 1);
4        int mask = (1 << bits) - 1;
5        return ~n & mask;
6    }
7}