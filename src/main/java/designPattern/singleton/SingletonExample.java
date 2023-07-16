package designPattern.singleton;

public class SingletonExample {

  /*
   lazy initialization
  private static SingletonExample obj;

    private SingletonExample()
    {

    }

    static SingletonExample getInstance()
    {
        if(obj ==null)
            return new SingletonExample();
        else
            return obj;
    }*/
/*  *//*Eager initialization*//*
    private static SingletonExample obj = new SingletonExample();
    private SingletonExample()
    {}
    static  SingletonExample getInstance()
    {
        return obj;
    }*/

    /*private static SingletonExample obj;

    private SingletonExample()
    {

    }
    static  synchronized  SingletonExample getInstance()
    {
        if(obj ==null)
            return new SingletonExample();
        else
            return obj;
    }*/
  /*best Way*/
    private static volatile SingletonExample obj;

    private SingletonExample()
    {

    }
    static  SingletonExample getInstance()
    {
        if(obj ==null) {
            synchronized (SingletonExample.class)
            {
                if(obj ==null)
                {
                    obj = new SingletonExample();
                }
            }
        }
            return obj;
    }
}
