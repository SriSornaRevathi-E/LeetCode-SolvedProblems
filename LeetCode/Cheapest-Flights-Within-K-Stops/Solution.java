1class Solution {
2    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
3       List<int[]>[] graph=new List[n];
4       for(int i=0;i<n;i++){
5        graph[i]=new ArrayList<>();
6       }
7       for(int[] flight:flights){
8        graph[flight[0]].add(new int[] {flight[1],flight[2]});
9       }
10       int[] dist=new int[n];
11       Arrays.fill(dist,Integer.MAX_VALUE);
12       dist[src]=0;
13       Queue<int[]> q=new LinkedList<>();
14       q.add(new int[]{src,0,0});
15       while(!q.isEmpty()){
16        int[] node=q.poll();
17        int u=node[0];
18        int d=node[1];
19        int stop=node[2];
20        if(stop>k){
21            continue;
22        }
23        for(int[] edge:graph[u]){
24            int v=edge[0];
25            int w=edge[1];
26            if(dist[v]>d+w){
27                dist[v]=d+w;
28                q.add(new int[]{v,dist[v],stop+1});
29
30            }
31        }
32    }
33    return dist[dst]==Integer.MAX_VALUE ?-1:dist[dst];
34    }
35}
36