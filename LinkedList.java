public class LinkedList implements List{

    Node head;
    int size = 0;



    public class Node {
        public Object data;
        public Node next;
    }


    LinkedList()
    {
        head = new Node();
        this.head = null;
        this.size =0 ;


    }

    @Override
    public void add(Object obj) throws Exception {
            Node node = new Node();
            node.data=obj;
            node.next = head;
            head = node;
            ++size;


    }

    @Override
    public void add(int pos, Object data) throws Exception {
        if(pos<0 || pos > size) throw new Exception() ;

        if(pos == 0){
            Node node = new Node();
            node.data=data;
            node.next = head;
            head = node;
            ++size;
        } else {
            Node previous = getNode(pos-1);
            Node node = new Node();
            node.data = data;
            node.next = previous.next;
            previous.next = node;
            ++size;

        }

    }


    @Override
    public Object get(int pos) throws Exception {
        if(pos < 0 || pos > size) throw new Exception();

        Node curr = getNode(pos);
        return curr.data;
    }

    @Override
    public Object remove(int pos) throws Exception {
        if( pos < 0 || pos > size) throw new Exception();

        if(pos == 0){
            Node curr=head;
            head=head.next;

            --size;
            return curr.data;
        } else {
            Node previous=getNode(pos-1);
            Node curr=previous.next;
            previous.next= curr.next;
            --size;
            return curr.data;
        }
    }

    @Override
    public int size() {
        return size;
    }

    Node getNode(int pos){
        Node node = head;
        for(int i=0;i<pos;i++){
            node =node.next;
        }

        return node;

    }


}