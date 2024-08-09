package Repository;

import model.Customer;
import model.Invoice;
import model.Phone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static controller.StoreController.InvoiceMap;

public class ReadFileInvoice {
    public static void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/data/ProductInvoice.csv"));
            String line;
            List<String> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
//            invoiceID,nameCustomer,addressCustomer,phoneNumberCustomer,emailCustomer,namePhone,imei,model,price,color,capacity
            for (int i = 1; i < list.size(); i++) {
                String[] parts = list.get(i).split(",");
                int invoiceID = Integer.parseInt(parts[0]);
                String nameCustomer = parts[1];
                String addressCustomer = parts[2];
                double phoneNumberCustomer = Double.parseDouble(parts[3]);
                String emailCustomer = parts[4];
                Customer customer = new Customer(nameCustomer, addressCustomer, phoneNumberCustomer, emailCustomer);
                String namePhone = parts[5];
                double imeiPhone = Double.parseDouble(parts[6]);
                int myImeiPhone = (int) imeiPhone;
                String modelPhone = parts[7];
                double pricePhone = Double.parseDouble(parts[8]);
                String colorPhone = parts[9];
                int capacityPhone = (int)Double.parseDouble(parts[10]);
                String dateInvoice = parts[11];
                Phone phone =new Phone(namePhone,myImeiPhone,modelPhone,pricePhone,colorPhone,capacityPhone);
                Invoice invoice = new Invoice(invoiceID,customer,phone,dateInvoice);
                InvoiceMap.put(invoiceID,invoice);
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
