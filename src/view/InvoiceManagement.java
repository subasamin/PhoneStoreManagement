package view;

import controller.InvoiceController;

import java.util.Scanner;

public class InvoiceManagement {
    public static void invoiceManagement() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Hoá đơn bán hàng");
            System.out.println("1. Tạo hoá đơn.");
            System.out.println("2. In Hoá đơn.");
            System.out.println("3. Trở về menu chính.");
            System.out.println("Nhập một số để chọn.");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    InvoiceController.createInvoice();
                    break;
                case 2:
                    InvoiceController.printInvoice();
                    break;
                case 3:
                    ReturnMenuStore.menuStore();
                    break;
                default:
                    System.out.println("Xin mời bạn nhập lại !");
            }
        } while (true);
    }
}
