package controller;

import Repository.WriteFileCustomer;
import Repository.WriteFileInvoice;
import Repository.WriteFileProductSold;
import model.Customer;
import model.Invoice;
import model.Phone;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static controller.StoreController.*;
import static controller.Validate.ValidateImeiProduct;
import static controller.Validate.ValidatePrice;

public class InvoiceController {
    public static void createInvoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Điền thông tin hoá đơn");
        System.out.println("1.Nhập thông tin khách hàng.");
        System.out.println("Nhập tên khách hàng.");
        String nameCustomer = sc.nextLine();
        System.out.println("Nhập số điện thoại của khách hàng.");
        String phoneCustomer = sc.nextLine();
        System.out.println("Nhập địa chỉ của khách hàng.");
        String addresslCustomer = sc.nextLine();
        System.out.println("Nhập email cua khách hàng.");
        String emailCustomer = sc.nextLine();
        Customer customer = new Customer(nameCustomer, addresslCustomer, Integer.parseInt(phoneCustomer), emailCustomer);
        CustomersMap.put(CustomersMap.size() + 1, customer);
        WriteFileCustomer.writeFile();

        Scanner sc1 = new Scanner(System.in);
        System.out.println("2. Thông tin sản phẩm ");
        System.out.println("Nhập imei sản phẩm khách hàng mua.");
        String imei = sc1.nextLine();
        while (ValidateImeiProduct(imei)) {
            System.out.println("Imei sản phẩm không hợp lệ, mời bạn nhập lại !");
            imei = sc1.nextLine();
        }
        while (ProductInventoryMap.containsKey(Integer.parseInt(imei))==false){
            System.out.println("Sản phẩm vừa nhập khồng còn trong kho, mời bạn nhập lại.");
            imei = sc1.nextLine();
        }
        System.out.println("Thông tin của sản phẩm là.");
        System.out.println(ProductInventoryMap.get(Integer.parseInt(imei)));
        System.out.println("Nhập giá bán của sản phẩm.");
        String priceOut = sc1.nextLine();
        while (ValidatePrice(priceOut)) {
            System.out.println("Giá của sản phẩm không hợp lệ, mời bạn nhập lại !");
            priceOut = sc1.nextLine();
        }
        System.out.println("Đã tạo thành công hoá đơn");
        Phone producSold = AllProductMap.get(Integer.parseInt(imei));
        producSold.setPrice(Double.parseDouble(priceOut));
        ProductSoldMap.put(producSold.getImei(), producSold);
        WriteFileProductSold.writeFile();

        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String timeformatted = time.format(formatter);
        int invoiceId = InvoiceMap.size() + 1;
        Invoice invoice = new Invoice(invoiceId, customer, ProductSoldMap.get(Integer.parseInt(imei)), timeformatted);
        InvoiceMap.put(invoiceId, invoice);
        WriteFileInvoice.writeFile();
        System.out.println(invoice);
    }

    public static void printInvoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã id hoá đơn cần in.");
        int invoiceId = sc.nextInt();
        System.out.println("Hoá đơn cần in là");
        System.out.println("          Hoá đơn bán hàng          ");
        System.out.println("1.Thông tin khách hàng ");
        System.out.println("   Họ và tên: "+InvoiceMap.get(invoiceId).getCustomer().getName());
        System.out.println("   Địa chỉ: "+InvoiceMap.get(invoiceId).getCustomer().getAddress());
        System.out.println("   Số điện thoại: "+InvoiceMap.get(invoiceId).getCustomer().getPhoneNumber());
        System.out.println("   Email: "+InvoiceMap.get(invoiceId).getCustomer().getEmail());
        System.out.println("2.Thông tin sản phẩm");
        System.out.println("   Tên sản phẩm: "+InvoiceMap.get(invoiceId).getProducts().getName());
        System.out.println("   Imei sản phẩm: "+InvoiceMap.get(invoiceId).getProducts().getImei());
        System.out.println("   Model sản phẩm: "+InvoiceMap.get(invoiceId).getProducts().getModel());
        System.out.println("   Giá bán: "+InvoiceMap.get(invoiceId).getProducts().getPrice());
        System.out.println("   Màu sản phẩm: "+InvoiceMap.get(invoiceId).getProducts().getColor());
        System.out.println("   Dung lượng sản phẩm: "+InvoiceMap.get(invoiceId).getProducts().getCapacity());
        System.out.println("3.Ngày bán sản phẩm là: "+InvoiceMap.get(invoiceId).getDate());
        System.out.println("        Cảm ơn khách hàng luôn tin tưởng ủng hộ        +/n");
    }
}


