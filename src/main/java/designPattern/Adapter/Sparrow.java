package designPattern.Adapter;

public class Sparrow implements Birds{

    @Override
    public void fly() {
        System.out.println("flying");
    }

    @Override
    public void makeSound() {
        System.out.println("Chirps Chirps");
    }
}
