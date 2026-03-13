class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a,b) -> Long.compare(a[0], b[0])
        );

        for(int t : workerTimes){
            pq.offer(new long[]{t, t, 1});
        }

        long time = 0;

        while(mountainHeight > 0){
            long[] cur = pq.poll();

            time = cur[0];
            long base = cur[1];
            long k = cur[2];

            mountainHeight--;

            k++;
            long nextTime = time + base * k;

            pq.offer(new long[]{nextTime, base, k});
        }

        return time;
    }
}