package doubleLinkedList;

import data.Car;

public class DemoMDLL {
    public static void main(String[] args) {
        Car c1 = new Car("Ford", true, "Red");
        Car c2 = new Car("Audi", true, "Blue");
        Car c3 = new Car("Kia", false, "Gray");
        MyDoubleLinkedList<Car> linkedList = new MyDoubleLinkedList<Car>();
        linkedList.add(c1);
        System.out.println(linkedList);
        linkedList.add(c2);
        linkedList.add(c3);
        System.out.println(linkedList.size());
        System.out.println(linkedList);
    }
}
