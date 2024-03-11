abstract class Animal {
  public abstract void animalSound();
  public void sleep() {
    System.out.println("Zzz");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
}

class Dog extends Animal {
  public void animalSound() {
    System.out.println("The dog says: woof");
  }
}

class TestAbstraction {
  public static void main(String[] args) {
    Animal pig = new Pig();
    pig.animalSound();
    pig.sleep();

    Animal dog = new Dog();
    dog.animalSound();
    dog.sleep();
  }
}
