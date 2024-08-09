package view;

import controller.ProductController;
import java.io.IOException;
import java.util.Scanner;

public class ProductManagement {
    public static void productManagement() throws IOException {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Quản lý kho hàng");
            System.out.println("1.Danh sách toàn bộ sản phẩm đã nhập kho.");
            System.out.println("2.Danh sách toàn bộ sản phẩm tồn kho.");
            System.out.println("3.Danh sách các sản phẩm đã bán.");
            System.out.println("4.Tìm kiếm sản phẩm.");
            System.out.println("5.Thêm sản phẩm.");
            System.out.println("6.Xoá sản phẩm.");
            System.out.println("7.Trở về menu chính.");
            System.out.println("Nhập vào một số để chọn.");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ProductController.displayAllProducts();
                    break;
                case 2:
                    ProductController.displayProductInventory();
                    break;
                case 3:
                    ProductController.diplayProductSold();
                    break;
                case 4:
                    ProductController.findProduct();
                    break;
                case 5:
                    ProductController.addProduct();
                    break;
                case 6:
                    ProductController.deleteProduct();
                    break;
                case 7:
                    ReturnMenuStore.menuStore();
                default:
                    System.out.println("Xin mời bạn nhập lại !");
            }
        }
        while (true);
    }
}
