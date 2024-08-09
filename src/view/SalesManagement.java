package view;

import controller.SalesController;

import java.util.Scanner;

public class SalesManagement {
    public static void saleManagement() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Quản lý doanh số bán hàng.");
            System.out.println("1. Lợi nhuận trên từng sản phẩm.");
            System.out.println("2. Lợi nhuận từ các sản phẩm đã bán.");
            System.out.println("3. Tổng số tiền đã nhập hàng.");
            System.out.println("4. Tổng số tiền thu được từ bán hàng ( tính theo giá nhập )");
            System.out.println("5. Tổng số tiền hàng còn tồn trong kho.");
            System.out.println("6. Trở về menu chính");
            System.out.println("Nhập vào một số để thực hiện yêu cầu.");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    SalesController.profitOneProduct();
                    break;
                case 2:
                    SalesController.profitAllProductSold();
                    break;
                case 3:
                    SalesController.allPriceIn();
                    break;
                case 4:
                    SalesController.allPriceOut();
                    break;
                case 5:
                    SalesController.allPriceInventory();
                    break;
                case 6:
                    ReturnMenuStore.menuStore();
                    break;
                default:
                    System.out.println("Xin mời bạn nhập lại !");
            }
        }
        while (true);
    }
}
