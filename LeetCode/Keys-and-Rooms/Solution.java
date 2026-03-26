1class Solution {
2    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
3        boolean[] visited = new boolean[rooms.size()];
4        Queue<Integer> q = new LinkedList<>();
5        q.add(0);
6        visited[0] = true;
7        while (!q.isEmpty()) {
8            int room = q.poll();
9            for (int key : rooms.get(room)) {
10                if (!visited[key]) {
11                    visited[key] = true;
12                    q.add(key);
13                }
14            }
15        }
16        for (boolean v : visited) {
17            if (!v){
18                 return false;
19            }
20        }
21        return true;
22    }
23}