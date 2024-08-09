package Repository;

import model.Invoice;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static controller.StoreController.InvoiceMap;

public class WriteFileInvoice {
    public static void writeFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/ProductInvoice.csv"));
            bw.append("invoiceID,nameCustomer,addressCustomer,phoneNumberCustomer,emailCustomer,namePhone,imei,model,price,color,capacity,dateInvoice");
            bw.append("\n");
            for (Invoice invoice : InvoiceMap.values()) {
                bw.append(Integer.toString(invoice.getInvoiceId()));
                bw.append(',');
                bw.append(invoice.getCustomer().getName());
                bw.append(',');
                bw.append(invoice.getCustomer().getAddress());
                bw.append(',');
                bw.append(Double.toString(invoice.getCustomer().getPhoneNumber()));
                bw.append(',');
                bw.append(invoice.getCustomer().getEmail());
                bw.append(',');
                bw.append(invoice.getProducts().getName());
                bw.append(',');
                bw.append(Double.toString(invoice.getProducts().getImei()));
                bw.append(',');
                bw.append(invoice.getProducts().getModel());
                bw.append(',');
                bw.append(Double.toString(invoice.getProducts().getPrice()));
                bw.append(',');
                bw.append(invoice.getProducts().getColor());
                bw.append(',');
                bw.append(Double.toString(invoice.getProducts().getCapacity()));
                bw.append(',');
                bw.append(invoice.getDate());
                bw.append('\n');
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
