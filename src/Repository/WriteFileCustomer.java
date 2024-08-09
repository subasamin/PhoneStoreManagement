package Repository;

import model.Customer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static controller.StoreController.CustomersMap;

public class WriteFileCustomer {
    public static void writeFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/Customer.csv"));
            bw.append("nameCustomer,addressCustomer,phoneCustomer,emailCustomer");
            bw.append("\n");
            for (Customer customer : CustomersMap.values()) {
                bw.append(customer.getName());
                bw.append(',');
                bw.append(customer.getAddress());
                bw.append(',');
                bw.append(Double.toString(customer.getPhoneNumber()));
                bw.append(',');
                bw.append(customer.getEmail());
                bw.append('\n');
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
