package collection;

public class CustomLinkedlist {

    private Node head;

    public void insert( Object o)
    {
        Node node = new Node();
        node.setData(o);
        node.setNext(null);
        if(head == null)
            head = node;
        else
        {
             Node temp = head;
            while(temp.getNext()!=null)
            {
                temp = temp.getNext();
            }
               temp.setNext(node);
        }
    }
    public void insertAtFirst(Object o)
    {
        Node node = new Node();
        node.setData(o);
        node.setNext(head);
        head = node;
    }
    public void insertAtIndex(Object o , int index)
    {
        Node node = new Node();
        node.setData(o);
        node.setNext(null);
        Node temp  = head;
        int count = 0;
        if(index == 0)
        {
            insertAtFirst(o);
        }
        else {
            while (temp.getNext() != null && count != index - 1) {
                count++;
                temp = temp.getNext();
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
    }

    public void show()
    {
        Node temp = head;
        while(temp.getNext()!=null)
        {
            System.out.println(temp.getData());
            temp = temp.getNext();

        }
        System.out.println(temp.getData());
    }

    public void  removeAtIndex(int index)
    {
         if(index == 0)
         {
              Node removeNode = head;
               head = head.getNext();
               removeNode = null;
         }
         else
         {
             int count = 0;
             Node  temp = head;
                     while(temp.getNext()!=null && count!= index - 1)
                     {
                         temp = temp.getNext();
                         count ++;
                     }
                     Node removeNode = temp.getNext();
                     temp.setNext(removeNode.getNext());
             System.out.println("element was remove is "+removeNode.getData().toString());
                     removeNode = null;
         }

    }

}

 class Node
{
    private Object data;
    private Node next;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedListTest
{
    public static void main (String [] arg)
    {
        CustomLinkedlist list = new CustomLinkedlist();
         list.insert(10);
         list.insert(20);
         list.insert(30);
        list.insert(450);
        list.insert(201);
        list.insert(350);
        System.out.println("LinkedList is : ");
        list.show();
        /*list.insertAtFirst(18);
        System.out.println("list after adding element at first place");
        list.show();*/
        /*System.out.println("list after adding element at index 0");
        list.insertAtIndex(26,0);
        list.show();*/
        list.removeAtIndex(2);
        list.show();

    }
}
