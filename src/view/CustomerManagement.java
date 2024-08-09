package view;

import controller.CustomerController;
import java.util.Scanner;

public class CustomerManagement {
    public static void customerManagement() {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Hiển thị toàn bộ khách hàng.");
            System.out.println("2. Nhập id khách hàng để hiển thị.");
            System.out.println("3. Quay về menu chính.");
            System.out.println("Nhập vào một số.");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    CustomerController.displayAllCustomers();
                    break;
                case 2:
                    CustomerController.findCustomerById();
                    break;
                case 3:
                    ReturnMenuStore.menuStore();
                    break;
                default:
                    System.out.println("Số bạn vừa nhập không hợp lệ, mời bạn nhập lại !");
                    break;
            }
        }
        while (true);
    }
}
