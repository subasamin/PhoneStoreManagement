package Repository;

import model.Customer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static controller.StoreController.CustomersMap;

public class ReadFileCustomer {
    public static void readFile() {
            try {
            BufferedReader br = new BufferedReader(new FileReader("src/data/Customer.csv"));
            String line;
            List<String> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            for (int i = 1; i < list.size(); i++) {
                String[] parts = list.get(i).split(",");
                String nameCustomer = parts[0];
                String addresCustomer = parts[1];
                double phoneNumberCustomer = Double.parseDouble(parts[2]);
                String emailCustomer = parts[3];
                Customer customer = new Customer(nameCustomer, addresCustomer, phoneNumberCustomer, emailCustomer);
                CustomersMap.put(CustomersMap.size() +1, customer);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
