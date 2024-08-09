package controller;


import Repository.WriteFileAllProduct;
import Repository.WriteFileProductInventory;
import model.Phone;
import model.Product;
import view.ProductManagement;
import view.ReturnMenuStore;
import java.io.IOException;
import java.util.Scanner;
import static controller.StoreController.*;
import static controller.Validate.*;

public class ProductController {

    public static void addProduct() throws IOException {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Thêm sản phẩm.");
            System.out.println("2. Quay lại mục trước.");
            System.out.println("3. Quay lại menu chính.");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addProduct1();
                    break;
                case 2:
                    ProductManagement.productManagement();
                    break;
                case 3:
                    ReturnMenuStore.menuStore();
                    break;
                default:
                    System.out.println("Xin mời bạn nhập lại !");
            }
        } while (true);
    }

    private static void addProduct1() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập thông tin sản pẩm cần thêm");
        System.out.println("Nhập tên sản phẩm.");
        String name = scanner.nextLine();
        while (ValidateName(name)) {
            System.out.println("Tên sản phẩm không hợp lệ, mời bạn nhập lại !");
            name = scanner.nextLine();
        }
        System.out.println("Nhập imei của sản phẩm.");
        String imei = scanner1.nextLine();
        while (ValidateImeiProduct(imei)) {
            System.out.println("Imei sản phẩm không hợp lệ, mời bạn nhập lại !");
            imei = scanner1.nextLine();
        }
        System.out.println("Nhập model của sản phẩm.");
        String model = scanner2.nextLine();
        while (ValidateName(model)) {
            System.out.println("Model sản phẩm không hợp lệ, mời bạn nhập lại !");
            model = scanner.nextLine();
        }
        System.out.println("Nhập màu của sản phẩm.");
        String color = scanner.nextLine();
        while (ValidateColor(color)) {
            System.out.println("Màu sản phẩm không hợp lệ, mời bạn nhập lại !");
            color = scanner.nextLine();
        }
        System.out.println("Nhập giá của sản phẩm.");
        String price = scanner1.nextLine();
        while (ValidatePrice(price)) {
            System.out.println("Giá của sản phẩm không hợp lệ, mời bạn nhập lại !");
            price = scanner.nextLine();
        }
        System.out.println("Nhập dung lượng của sản phẩm.");
        String capacity = scanner.nextLine();
        while (ValidateCapacity(capacity)) {
            System.out.println("Dung lượng của sản phẩm không hợp lệ, mời bạn nhập lại !");
            capacity = scanner.nextLine();
        }
        Phone Product = new Phone(name, Integer.parseInt(imei), model, Double.parseDouble(price), color, Integer.parseInt(capacity));
        AllProductMap.put(Integer.parseInt(imei), Product);
        System.out.println("Đã thêm thành công sản phẩm.");
        WriteFileAllProduct.writeFile();

    }

    public static void deleteProduct() throws IOException {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Chọn sản phẩm để xoá.");
            System.out.println("2. Trở về menu trước.");
            System.out.println("3. Trở về menu chính.");
            System.out.println("Nhập vào một số để chọn.");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    removeProduct();
                    break;
                case 2:
                    ProductManagement.productManagement();
                case 3:
                    ReturnMenuStore.menuStore();
            }
        } while (true);
    }

    private static void removeProduct() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập imei sản phẩm cần xoá.");
        String imei = scanner.nextLine();
        while (ValidateImeiProduct(imei)) {
            System.out.println("Imei sản phẩm không hợp lệ, mời bạn nhập lại !");
            imei = scanner.nextLine();
        }
        if (AllProductMap.containsKey(Integer.parseInt(imei))) {
            System.out.println("Bạn chắc chắn muốn xoá sản phẩm này không ?");
            System.out.println(AllProductMap.get(Integer.parseInt(imei)));
            System.out.println("Nhập Yes hoặc No");
            String index = scanner.nextLine();
            if (index.equals("Yes")) {
                AllProductMap.remove(Integer.parseInt(imei));
                ProductInventoryMap.remove(Integer.parseInt(imei));
                System.out.println("Xoá thành công sản phẩm với imei là: " + imei);
                WriteFileAllProduct.writeFile();
            } else if (index.equals("No")) {
                deleteProduct();
            }
        } else {
            System.out.println("Sản phẩm vừa nhập không có.");
        }
    }

    public static void findProduct() throws IOException {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Chọn sản phẩm cần tìm.");
            System.out.println("2. Trở về menu trước.");
            System.out.println("3. Trở về menu chính.");
            System.out.println("Nhập vào một số để chọn.");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    findOneProductInAllProduct();
                    break;
                case 2:
                    ProductManagement.productManagement();
                    break;
                case 3:
                    ReturnMenuStore.menuStore();
                    break;
                default:
                    System.out.println("Số bạn nhập không đúng, mời bạn nhập lại !");
                    break;
            }
        } while (true);
    }

    private static void findOneProductInAllProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập imei sản phẩm cần tìm kiếm");
        String imei = scanner.nextLine();
        while (ValidateImeiProduct(imei)) {
            System.out.println("Imei sản phẩm không hợp lệ, mời bạn nhập lại !");
            imei = scanner.nextLine();
        }
        if (AllProductMap.containsKey(Integer.parseInt(imei))) {
            System.out.println("Sản phẩm với imei: " + imei + " là");
            System.out.println(AllProductMap.get(Integer.parseInt(imei)));
        } else {
            System.out.println("Imei bạn vừa nhập không có");
        }
    }

    public static void displayAllProducts() throws IOException {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Hiển thị toàn bộ sản phẩm");
            System.out.println("2. Trở về menu trước");
            System.out.println("3. Trở về menu chính");
            System.out.println("Nhập vào một số để chọn");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Danh sách tất cả các sản phẩm đã nhập kho là");
                    for (Phone product : AllProductMap.values()) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    ProductManagement.productManagement();
                    break;
                case 3:
                    ReturnMenuStore.menuStore();
                    break;
                default:
                    System.out.println("Số bạn nhập không hợp lệ, mời bạn nhập lại");
            }
        } while (true);
    }

    public static void displayProductInventory() throws IOException {
        ProductInventoryMap();
        WriteFileProductInventory.writeFile();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Tìm kiếm theo imei");
            System.out.println("2. Hiển thị toàn bộ danh sách");
            System.out.println("3. Trở về menu trước");
            System.out.println("4. Trở về menu chính");
            System.out.println("Nhập vào một số để chọn");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập imei sản phẩm cần tìm");
                    String imei = scanner.nextLine();
                    while (ValidateImeiProduct(imei)) {
                        System.out.println("Imei sản phẩm không hợp lệ, mời bạn nhập lại !");
                        imei = scanner.nextLine();
                    }
                    if (ProductInventoryMap.containsKey(Integer.parseInt(imei))) {
                        System.out.println(ProductInventoryMap.get(Integer.parseInt(imei)));
                    } else {
                        System.out.println("Imei bạn vừa nhập không có");
                    }
                    break;
                case 2:
                    System.out.println("Danh sách các sản phẩm còn tồn kho là: ");
                    for (Product productInventory : ProductInventoryMap.values()) {
                        System.out.println(productInventory);
                    }
                    break;
                case 3:
                    ProductManagement.productManagement();
                    break;
                case 4:
                    ReturnMenuStore.menuStore();
                    break;
                default:
                    System.out.println("Số bạn nhập không đúng, mời bạn nhập lại !");
                    break;
            }
        } while (true);
    }
    private static void ProductInventoryMap() {
        int index;
        for (Phone product : AllProductMap.values()) {
            ProductInventoryMap.put(product.getImei(), product);
        }
        for (Product product : ProductSoldMap.values()) {
            index = product.getImei();
            ProductInventoryMap.remove(index);
        }
    }

    public static void diplayProductSold() throws IOException {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1.Tìm kiếm theo imei");
            System.out.println("2.Hiển thị toàn bộ danh sách");
            System.out.println("3. Trở về menu trước");
            System.out.println("4. Trở về menu chính");
            System.out.println("Nhập vào một số để chọn");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    findProductSold();
                    break;
                case 2:
                    System.out.println("Danh sách các sản phẩm đã bán là: ");
                    for (Product productSold : ProductSoldMap.values()) {
                        if (productSold==null){
                            System.out.println("Không có sản phẩm nào");
                        }
                        else {
                            System.out.println(productSold);
                        }
                    }
                case 3:
                    ProductManagement.productManagement();
                case 4:
                    ReturnMenuStore.menuStore();
            }
        } while (true);
    }

    private static void findProductSold() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập imei sản phẩm đã bán cần tìm kiếm ");
        String imei = scanner.nextLine();
        while (ValidateImeiProduct(imei)) {
            System.out.println("Imei sản phẩm không hợp lệ, mời bạn nhập lại !");
            imei = scanner.nextLine();
        }
        while (!ProductSoldMap.containsKey(Integer.parseInt(imei))) {
            System.out.println("Sản phẩm này không có trong sanh sách sản phẩm đã bán, mời bạn nhập lại !");
            imei = scanner.nextLine();
        }
        if (ProductSoldMap.containsKey(Integer.parseInt(imei))) {
            System.out.println("Thông tin sản phẩm có imei " + imei + "là: ");
            System.out.println(ProductSoldMap.get(Integer.parseInt(imei)));
        } else {
            System.out.println("Imei vừa nhập không có");
        }
    }

}

