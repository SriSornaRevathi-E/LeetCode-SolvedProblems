class Solution {
    public int flipsForZeroStart(int oneAtOdd, int oneAtEven, int zeroAtOdd, int zeroAtEven) {
        // zero should be at even pos, ones at odd pos, zero at odd and ones at even should be flipped.
        return zeroAtOdd + oneAtEven;
    }

    public int flipsForOneStart(int oneAtOdd, int oneAtEven, int zeroAtOdd, int zeroAtEven) {
        // one should be at even pos, zeros at odd pos.
        return oneAtOdd + zeroAtEven;
    }

    public int minFlips(String s) {
        int oneAtOdd = 0;
        int oneAtEven = 0;
        int zeroAtOdd = 0;
        int zeroAtEven = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                if (i % 2 == 0) zeroAtEven++;
                else zeroAtOdd++;
            } else {
                if (i % 2 == 0) oneAtEven++;
                else oneAtOdd++;
            }
        }

        boolean isLastIndexEven = (s.length() % 2 == 1);
        // Get min flips to make current string alternating.
        int minAnswer = Math.min(flipsForZeroStart(oneAtOdd, oneAtEven, zeroAtOdd, zeroAtEven), 
                                  flipsForOneStart(oneAtOdd, oneAtEven, zeroAtOdd, zeroAtEven));

        // Get min flips to make the new string alternating, after one character rotation.
        // At most we can do s.length - 1 rotation after that we will have initial string only.
        // We will not perform the push operation in the string we are just simulating it by incrementing the index and updating count variables.
        for (int rotateCount = 1; rotateCount < s.length(); ++rotateCount) {
            int indexOfElementPushedAtBack = rotateCount - 1;
            
            // After pushing one element, counts will swap, as even pos will become odd and odd pos will become even.
            // 'indexOfElementPushedAtBack' char will be removed from even pos '0'.
            // and pushed at last index.

            if (s.charAt(indexOfElementPushedAtBack) == '0') {
                zeroAtEven--;
            } else {
                oneAtEven--;
            }

            int temp1 = oneAtOdd;
            oneAtOdd = oneAtEven;
            oneAtEven = temp1;

            int temp2 = zeroAtOdd;
            zeroAtOdd = zeroAtEven;
            zeroAtEven = temp2;

            if (s.charAt(indexOfElementPushedAtBack) == '0') {
                if (isLastIndexEven) zeroAtEven++;
                else zeroAtOdd++;
            } else {
                if (isLastIndexEven) oneAtEven++;
                else oneAtOdd++;
            }

            int currAns = Math.min(flipsForZeroStart(oneAtOdd, oneAtEven, zeroAtOdd, zeroAtEven), 
                                    flipsForOneStart(oneAtOdd, oneAtEven, zeroAtOdd, zeroAtEven));
            minAnswer = Math.min(minAnswer, currAns);
        }

        return minAnswer;
    }
}