package model;

public class Customer {
    private String Name;
    private String Address;
    private double PhoneNumber;
    private String Email;

    public Customer(String name, String address, double phoneNumber, String email) {
        Name = name;
        Address = address;
        PhoneNumber = phoneNumber;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(double phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Info Customer"+"Tên khách hàng: "+getName()+"  Địa chỉ khách hàng: "+getAddress()+"  Số điện thoại khách hàng: "+getPhoneNumber()+"  Email khách hàng: "+getEmail();
    }
}
