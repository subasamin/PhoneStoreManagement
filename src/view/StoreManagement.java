package view;

import java.io.IOException;
import java.util.Scanner;

import Repository.*;


public class StoreManagement {
    public static void main(String[] args) {
        ReadFileAllProduct.readFile();
        ReadFileProductSold.readFile();
        ReadFileProductInventory.readFile();
        ReadFileInvoice.readFile();
        ReadFileCustomer.readFile();

        Scanner input = new Scanner(System.in);
        System.out.println(" Quản lý bán hàng");
        System.out.println("1. Quản lý kho hàng.");
        System.out.println("2. Quản lý doanh số.");
        System.out.println("3. Hoá đơn bán hàng.");
        System.out.println("4. Quản lý khách hàng.");
        System.out.println("5. Kết thúc.");
        System.out.println("Nhập một số để thực hiện yêu cầu.");

        do {
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    try {
                        ProductManagement.productManagement();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    SalesManagement.saleManagement();
                    break;
                case 3:
                    InvoiceManagement.invoiceManagement();
                    break;
                case 4:
                    CustomerManagement.customerManagement();
                    break;
                case 5:
                default:
                    System.out.println("Xin mời bạn nhập lại !");
                    break;
            }
        }
        while (true);
    }
}

