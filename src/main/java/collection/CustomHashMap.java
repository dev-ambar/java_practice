package collection;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CustomHashMap {

    private LinkedList<Entry>[] backet;

    public CustomHashMap() {
        backet = new LinkedList[16];
    }

    public void put(Object o1, Object o2) {
        int index = (o1.hashCode() & backet.length - 1);
        LinkedList<Entry> temp = backet[index];
         if(temp == null)
             temp = new LinkedList<>();
        Entry n = new Entry();
        n.setKey(o1);
        n.setValue(o2);
        if (temp.size() == 0) {
            temp.add(n);
        } else {
            for(Entry n1 : temp)
            {
                if(o1.equals(n1.getKey()))
                {     n1.setValue(o2);
                      temp.add(temp.indexOf(n1), n1);
                      break;
                }
            }
            temp.addLast(n);
        }
        backet[index] = temp;

    }

    public Object get(Object key) {
        int index = (key.hashCode() & backet.length - 1);
        LinkedList<Entry> temp = backet[index];
        for (Entry o1 : temp) {
            if (key.equals(o1.getKey())) {
                return o1.getValue();
            }
        }
        return null;
    }
    public Set<Entry> getEntrySet()
    {
        Set<Entry> nodeSet = new HashSet<>();

        for(int i= 0 ; i< backet.length ; i++)
        {
             LinkedList<Entry> temp = backet[i];
              if(temp!=null)
              {
                   for(Entry n : temp)
                   {
                       nodeSet.add(n);
                   }
              }
        }
        return nodeSet;
    }

}

class Entry {
    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    private Object key;
    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }


}

class  HashMapTest
{
    public static void main(String [] arg)
    {
        CustomHashMap hmp = new CustomHashMap();
        hmp.put(1,"Ambar");
        hmp.put(2,"Shivangi");
        hmp.put(3,"Aarav");
        hmp.put(4,"Mummy");
        hmp.put(5,"Papa");
        hmp.put(6,"Beta");
        hmp.put(7,"Ladoo");
        hmp.put(8,"Gopal");
        //System.out.println(hmp.get(1));
        for(Entry o : hmp.getEntrySet())
        {
            System.out.println("Key : " + o.getKey() +"  value : " + o.getValue());
        }

    }
}


