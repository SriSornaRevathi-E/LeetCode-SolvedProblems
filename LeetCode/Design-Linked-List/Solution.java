1class MyLinkedList {
2
3    class Node{
4        int val;
5        Node next;
6        Node prev;
7        public Node(int val){
8            this.val = val;
9        }
10    }
11    int size;
12    Node head;
13    Node tail;
14    public MyLinkedList(){
15        head = tail = null;
16        size = 0;
17    }
18    public int get(int index){
19        if(index < 0 || index >= size){
20            return -1;
21        }
22        Node temp = head;
23        for(int i = 0; i < index; i++){
24            temp = temp.next;
25        }
26        return temp.val;
27    }
28    public void addAtHead(int val) {
29        Node newNode = new Node(val);
30        if(head == null){
31            head = tail = newNode;
32        }
33        else{
34            newNode.next = head;
35            head.prev = newNode;
36            head = newNode;
37        }
38        size++;
39    }
40    public void addAtTail(int val) {
41        Node newNode = new Node(val);
42        if(tail == null){
43            head = tail = newNode;
44        }
45        else{
46            tail.next = newNode;
47            newNode.prev = tail;
48            tail = newNode;
49        }
50        size++;
51    }
52    public void addAtIndex(int index, int val) {
53
54        if(index < 0 || index > size){
55            return;
56        }
57        if(index == 0){
58            addAtHead(val);
59            return;
60        }
61        if(index == size){
62            addAtTail(val);
63            return;
64        }
65        Node temp = head;
66        for(int i = 0; i < index; i++){
67            temp = temp.next;
68        }
69        Node newNode = new Node(val);
70        newNode.prev = temp.prev;
71        newNode.next = temp;
72        temp.prev.next = newNode;
73        temp.prev = newNode;
74        size++;
75    }
76    public void deleteAtIndex(int index) {
77        if(index < 0 || index >= size){
78            return;
79        }
80        if(index == 0){
81            head = head.next;
82            if(head != null){
83                head.prev = null;
84            }
85            else{
86                tail = null;
87            }
88        }
89        else if(index == size - 1){
90            tail = tail.prev;
91            tail.next = null;
92        }
93        else{
94
95            Node temp = head;
96            for(int i = 0; i < index; i++){
97                temp = temp.next;
98            }
99            temp.prev.next = temp.next;
100            temp.next.prev = temp.prev;
101        }
102        size--;
103    }
104}
105/**
106 * Your MyLinkedList object will be instantiated and called as such:
107 * MyLinkedList obj = new MyLinkedList();
108 * int param_1 = obj.get(index);
109 * obj.addAtHead(val);
110 * obj.addAtTail(val);
111 * obj.addAtIndex(index,val);
112 * obj.deleteAtIndex(index);
113 */