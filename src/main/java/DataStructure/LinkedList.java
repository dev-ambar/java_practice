package DataStructure;

public class LinkedList {

     private Node head;

     public void insert(Object obj)
     {
         Node node = new Node();
         node.element = obj;
         node.next = null;
            if(head == null)
                head = node;
            else
            {
                Node temp = head;
                 while(temp.next!=null) {
                       temp = temp.next;
                 }
                  temp.next = node;
            }
     }
     public void insertAtFirst(Object obj)
     {
         Node node = new Node();
         node.element = obj;
         node.next = head;
         head = node;

     }
     public void insertAt(Object obj,int index)
     {
         if(index == 0)
             insertAtFirst(obj);
         else
         {
                Node temp = head;
                int i = 0;
                while(temp.next!=null && i < index-1)
                {
                    temp = temp.next;
                     i++;
                }
                  Node node = new Node();
                    node.element= obj;
                    node.next = temp.next ;
                    temp.next = node;
         }
     }

     void show()
     {
         Node temp = head;
         while(temp.next!=null) {
             System.out.println(temp.element);
             temp = temp.next;
         }
         System.out.println(temp.element);
     }

}

class Node
{
     Object element;
     Node next;
}
