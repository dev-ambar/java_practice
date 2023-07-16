package designPattern.Adapter;

public class BirdAdapter implements ToyBirds {

    public Birds birds;

    public BirdAdapter(Birds birds) {
        this.birds = birds;
    }

    @Override
    public void squeak() {
        birds.fly();
        birds.makeSound();
    }
}

 class Test
 {
     public static void main(String[] args) {

         Sparrow sparrow = new Sparrow();
         ToyBirds toyDuck = new ToyDuck();

         ToyBirds birdAdapter = new BirdAdapter(sparrow);

         System.out.println("Sparrow is ");
         sparrow.fly();
         sparrow.makeSound();

         System.out.println("toy duck is");
         toyDuck.squeak();
         // toyDuck behave like birds
         System.out.println("Using birds Adapter");
         birdAdapter.squeak();
     }
 }
