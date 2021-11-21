public class Jiceng {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.bark();
        System.out.println("改变成Cat");
        animal = new Cat();
        animal.bark();
        animal = new Dog();
        animal.bark();

    }
}
class Animal{
    public void bark(){
        System.out.println("This is animal\n");
    }
}

class Dog extends Animal{
    public void bark(){
        System.out.println("wang wang");
    }
}
class Cat extends Animal{
    public void bark(){
        System.out.println("miao miao");
    }
}

