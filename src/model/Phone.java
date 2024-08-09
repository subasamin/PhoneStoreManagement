package model;

public class Phone extends Product{
    private String color;
    private int capacity;

    public Phone(String name, int imei, String model, double price, String color, int capacity) {
        super(name, imei, model, price);
        this.color = color;
        this.capacity = capacity;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + "  Color: "+color+"  Capacity: "+capacity+" }";
    }
}
