1class StockSpanner {
2    Stack<int[]> st;
3
4    public StockSpanner() {
5        st = new Stack<>();
6    }
7    
8    public int next(int price) {
9        int span=1;
10         while(!st.isEmpty() && st.peek()[0] <= price){
11            span += st.pop()[1];
12            //st.pop();
13        }
14        st.push(new int[]{price, span});
15        return span;
16    }
17}
18
19/**
20 * Your StockSpanner object will be instantiated and called as such:
21 * StockSpanner obj = new StockSpanner();
22 * int param_1 = obj.next(price);
23 */