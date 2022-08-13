package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


class HashSetImplementTest {

    public static void main(String[] arg) {
        HashSetImplement custom = new HashSetImplement();
        custom.add("Ambar");
        custom.add("Shivangi");
        custom.add("Aarav");
        custom.add("Ankur");
        for (Object s : custom)
        {
            System.out.println(s);
        }
        System.out.println("Size of Hashset" + custom.size());
        System.out.println("is hashset  empty" + custom.isEmpty());
        System.out.println("does hashset contain " + custom.contains("Ambar"));
    }

}

class HashSetImplement implements Set {

    private HashMap<Object, Object> backedMap = null;
    private static final Object PRESENT = new Object();

    public HashSetImplement() {
        backedMap = new HashMap<>();
    }

    @Override
    public int size() {
        return backedMap.size();
    }

    @Override
    public boolean isEmpty() {
        return backedMap.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return backedMap.containsKey(o);
    }

    @Override
    public Iterator iterator() {
        return backedMap.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return backedMap.put(o, PRESENT) == null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}


