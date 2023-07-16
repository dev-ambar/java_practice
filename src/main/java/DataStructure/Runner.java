package DataStructure;

public class Runner {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert("Jai");
        list.insert("Shri");
        list.insert("Ram");
        list.insert("SitaRam");
        System.out.println("linkedList have following number:");
        list.show();
        System.out.println("Adding Element at first");
        list.insertAtFirst("bolo");
        list.show();
        System.out.println("Adding Element at any index");
        list.insertAt("jiki",4);
        list.show();
    }
}
