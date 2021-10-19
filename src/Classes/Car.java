package Classes;

import Interfaces.ICar;

import java.util.ArrayList;

public class Car implements ICar {
    public static ArrayList<Car> cars = new ArrayList<>();
    private String make;
    private String model;
    private String color;
    private boolean rented = false;

    public Car(String make, String model, String color){
        this.make = make;
        this.color = color;
        this.model = model;
    }

    @Override
    public String getMake() {
        return this.make;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String isRented() {
        if (rented == true)
            return "Car is rented";
        else
            return "Car is not rented";
    }

    public boolean isRent(){
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
