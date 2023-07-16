package designPattern.Adapter;

public class ToyDuck implements ToyBirds{
    @Override
    public void squeak() {
        System.out.println("squeaking");
    }
}
