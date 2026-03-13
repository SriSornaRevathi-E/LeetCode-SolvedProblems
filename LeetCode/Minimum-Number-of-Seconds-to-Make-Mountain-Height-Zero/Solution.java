1class Solution {
2    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
3
4        PriorityQueue<long[]> pq = new PriorityQueue<>(
5            (a,b) -> Long.compare(a[0], b[0])
6        );
7
8        for(int t : workerTimes){
9            pq.offer(new long[]{t, t, 1});
10        }
11
12        long time = 0;
13
14        while(mountainHeight > 0){
15            long[] cur = pq.poll();
16
17            time = cur[0];
18            long base = cur[1];
19            long k = cur[2];
20
21            mountainHeight--;
22
23            k++;
24            long nextTime = time + base * k;
25
26            pq.offer(new long[]{nextTime, base, k});
27        }
28
29        return time;
30    }
31}