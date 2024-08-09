package controller;

import model.Customer;
import java.util.Scanner;
import static controller.StoreController.CustomersMap;

public class CustomerController {
    public static void displayAllCustomers() {
        System.out.println("Danh sách toàn bộ khách hàng là");
        for (Customer customer:CustomersMap.values()){
            System.out.println(customer);
        }
    }
    public static void findCustomerById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id khách hàng");
        int id = Integer.parseInt(scanner.nextLine());
        if (CustomersMap.containsKey(id)){
            Customer customer = CustomersMap.get(id);
            System.out.println("Thong tin khach hang la");
            System.out.println(customer);
        }
        else {
            System.out.println("Khong tim thay id khach hang, moi nhap lai");
        }
    }
}
