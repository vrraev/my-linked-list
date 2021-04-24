package data;

public class Person {
    int age;
    double weight;
    String name;
    boolean isWoman;
    long personalNumber;
    double height;
    Person[] friends;
    Car car;
    double money;

    Person(){
        System.out.println("Default constructor");
        this.age = 0;
        this.weight = 4;
    }
    Person(int age) {
        this();
        System.out.println("Constructor with one argument");
        this.age = age;
    }
    Person(int age, String name) {
        this();
        this.name = name;
        System.out.println("Constructor with two arguments");
    }
    Person(int age, String name, double height){
        this();
        this.height = height;
        System.out.println("Constructor with three arguments");
    }
    Person(String name, long personalNumber, boolean isMale) {
        this();
        this.name = name;
        this.personalNumber = personalNumber;
        this.isWoman = !isMale;
        this.friends = new Person[3];
    }

    void buyCar(Car c ) {
        if(this.money > c.price) {
            this.car = c;
            this.money -=c.price;
            c.changeOwner(this);
        } else {
            System.out.println("Cannot buy this car");
        }
    }

    void eat() {
        System.out.println("I am eating now");
    }
    void growUp() {
        age++;
    }
    void drinkWater(double liters) {
        if(liters > 1) {
            System.out.println("This is too much water!!!");
        } else {
            System.out.println(name + " is drinking " + liters + " water.");
        }
    }
}
