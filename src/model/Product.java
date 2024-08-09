package model;

public abstract class Product {
    private String Name;
    private int Imei;
    private String Model;
    private double Price;

    public Product(String name, int imei, String model, double price) {
        Name = name;
        Imei = imei;
        Model = model;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImei() {
        return Imei;
    }

    public void setImei(int imei) {
        Imei = imei;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Product: { Name: "+Name+"  Imei: "+Imei+"  Model: "+Model+"  Price: "+Price;
    }
}

