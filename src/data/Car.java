package data;

public class Car {
    private static int currentLeader;

    public String model;
    public int maxSpeed;
    public int currentSpeed;
    public int currentGear;
    public String color;
    public boolean isSportCar;
    public double price;
    public Person owner;

    public Car(String model, boolean isSport, String color, double price, int maxSpeed) {
        this(model, isSport, color);
        this.price = price;
        if(maxSpeed > 200) {
            if(this.isSportCar) {
                this.maxSpeed = maxSpeed;
            } else {
                this.maxSpeed = 200;
            }
        } else {
            this.maxSpeed = maxSpeed;
        }
    }

    public Car(String model, boolean isSport, String color) {
        this.model = model;
        this.isSportCar = isSport;
        this.color = color;
    }

    void changeOwner(Person p ) {
        this.owner = p;
    }

    double calculatePriceForScrap(double metalPrice) {
        double coef = 0.2;
        if(this.isSportCar) {
            coef += 0.05;
        }
        if(this.color.equalsIgnoreCase("Black") ||
            this.color.equalsIgnoreCase("White") ) {
            coef += 0.05;
        }
        return  coef*metalPrice;
    }

    boolean isMoreExpensive(Car c) {
        return this.price > c.price;
    }

    public static int getCurrentLeader() {
        return currentLeader;
    }

    public static void setCurrentLeader(int currentLeader) {
        if (currentLeader < 0){
            System.out.println("Invalid number for current leader!");
        } else {
            Car.currentLeader = currentLeader;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", isSportCar=" + isSportCar +
                '}';
    }
}
