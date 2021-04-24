package singleLinkedList;


import data.Car;

public class DemoMSLL {
    public static void main(String[] args) {

        Car c1 = new Car("Ford", true, "Red");
        Car c2 = new Car("Audi", true, "Blue");
        Car c3 = new Car("Kia", false, "Gray");

        MySingleLinkedList<Car> singleLinkedList = new MySingleLinkedList<>();

        singleLinkedList.add(c1);
        System.out.println(singleLinkedList);
        singleLinkedList.add(c2);
        System.out.println(singleLinkedList);
        singleLinkedList.add(c3, 0);
        System.out.println(singleLinkedList);
        singleLinkedList.remove(1);
        System.out.println(singleLinkedList);
        singleLinkedList.add(c1, 2);
        System.out.println(singleLinkedList);
        singleLinkedList.add(c1, 0);
        System.out.println(singleLinkedList);
        singleLinkedList.remove(3);
        System.out.println(singleLinkedList);
        singleLinkedList.add(c3);
        System.out.println(singleLinkedList);
        System.out.println(singleLinkedList.size());
        singleLinkedList.set(0, c2);
        System.out.println(singleLinkedList);
        singleLinkedList.set(3, c1);
        System.out.println(singleLinkedList);
    }
}
