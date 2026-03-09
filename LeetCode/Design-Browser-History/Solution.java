1class BrowserHistory {
2    class Node{
3        String url;
4        Node next;
5        Node prev;
6        Node(String url){
7            this.url = url;
8            this.next = null;
9            this.prev = null;
10        }
11    }
12    Node curr;
13    public BrowserHistory(String homepage) {
14        curr = new Node(homepage);
15    }
16    public void visit(String url) {
17        Node newNode = new Node(url);
18        curr.next = newNode;
19        newNode.prev = curr;
20        curr = newNode;
21    }
22    public String back(int steps) {
23        while(steps > 0 && curr.prev != null){
24            curr = curr.prev;
25            steps--;
26        }
27        return curr.url;
28    } 
29    public String forward(int steps) {
30        while(steps > 0 && curr.next != null){
31            curr = curr.next;
32            steps--;
33        }
34        return curr.url;
35    }
36}
37
38/**
39 * Your BrowserHistory object will be instantiated and called as such:
40 * BrowserHistory obj = new BrowserHistory(homepage);
41 * obj.visit(url);
42 * String param_2 = obj.back(steps);
43 * String param_3 = obj.forward(steps);
44 */