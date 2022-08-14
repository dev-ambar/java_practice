package miscellaneous.example.abstraction;

/*The abstract class can also be used to provide some implementation of the interface.
In such case, the end user may not be forced to override all the methods of the interface.*/

public interface A {
    void a();
    void b();
    void c();
    void d();

}

abstract class B implements A{

    public void b()
    {
        System.out.println("method b called");
    }
}

class M extends B
{

    @Override
    public void a() {
        System.out.println("method a called");
    }

    @Override
    public void c() {
        System.out.println("method c called");
    }

    @Override
    public void d() {
        System.out.println("method d called");
    }
}

class Test
{
    public static void main(String[] args) {

        A a = new M();
        a.a();
        a.b();
        a.c();
        a.d();
    }
}
