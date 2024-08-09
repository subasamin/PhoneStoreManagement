package controller;

import model.Phone;
import model.Product;

import java.util.Scanner;

import static controller.StoreController.*;

public class SalesController {

    public static void profitOneProduct() {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập imei của sản phẩm cần xem.");
            int imei = scanner.nextInt();
            double profit;
            if (ProductSoldMap.containsKey(imei)) {
                Double pricein = AllProductMap.get(imei).getPrice();
                Double priceout = ProductSoldMap.get(imei).getPrice();
                profit = priceout - pricein;
                System.out.println("Lợi nhuận từ việc bán sản phẩm với imei " + imei + " là: " + profit);
            } else {
                System.out.println("Imei bạn vừa nhập không có, xin mời bạn nhập lại ");
            }
        }
        while (false);
    }

    public static void profitAllProductSold() {
        double allProfit = 0;
        int index;
        double priceIn;
        double priceOut;
        double profit = 0;
        for (Product product : ProductSoldMap.values()) {
            index = product.getImei();
            priceIn = AllProductMap.get(index).getPrice();
            priceOut = ProductSoldMap.get(index).getPrice();
            profit = priceOut - priceIn;
            allProfit += profit;
        }
        System.out.println("Lợi nhuận từ các sản phẩm đã bán là: " + allProfit);
    }

    public static void allPriceIn() {
        double priceIn = 0;
        for (Phone product : AllProductMap.values()) {
            priceIn += product.getPrice();
        }
        System.out.println("Tổng số tiền hàng đã nhập là: " + priceIn);
    }

    public static void allPriceInventory() {
        double priceInventory = 0;
        for (Product product : ProductInventoryMap.values()) {
            priceInventory += product.getPrice();
        }
        System.out.println("Tổng số tiền hàng tồn kho là: " + priceInventory);

    }

    public static void allPriceOut() {
        double priceOut = 0;
        int index;
        for (Product product : ProductSoldMap.values()) {
            index = product.getImei();
            priceOut += AllProductMap.get(index).getPrice();
        }
        System.out.println("Tổng tiền hàng đã bán là (tính theo giá nhập): " + priceOut);
    }
}
