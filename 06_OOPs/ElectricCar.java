// Q2

class Automobile {
    protected String drive() {
        return "Driving vehicle";
    }
}

class Car extends Automobile {
    protected String drive() {
        return "Driving car";
    }
}

public class ElectricCar extends Car {
    public final String drive() {
        return "Driving electric car";
    } 

    public static void main(String[] args) {
        final Car car = new ElectricCar();
        System.out.println(car.drive());
    }
}

// Output : Driving electric car