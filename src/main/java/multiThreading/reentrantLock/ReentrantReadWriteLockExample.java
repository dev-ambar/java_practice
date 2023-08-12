package multiThreading.reentrantLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {

    private  ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private  ReentrantReadWriteLock.ReadLock  readlock = lock.readLock();
    private  ReentrantReadWriteLock.WriteLock writelock = lock.writeLock();

    private  void readResource()
    {
        readlock.lock();
        try
        {
            // readResource
        }
        finally {
            readlock.unlock();
        }
    }
    private  void writeResource()
    {
        writelock.lock();
        try
        {
            // writeResource
        }
        finally {
            writelock.unlock();
        }
    }

    public static void main(String[] args) {

        ReentrantReadWriteLockExample obj = new ReentrantReadWriteLockExample();
        Thread t1 = new Thread(() ->  obj.readResource()); t1.start();
        Thread t2 = new Thread(() ->   obj.readResource());t2.start();

        Thread t3 = new Thread(()-> obj.writeResource());t3.start();
        Thread t4 = new Thread(()-> obj.writeResource());t4.start();
    }
}

