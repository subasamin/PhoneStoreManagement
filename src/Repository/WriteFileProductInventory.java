package Repository;

import model.Phone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static controller.StoreController.ProductInventoryMap;

public class WriteFileProductInventory {
    public static void writeFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/ProductInventory.csv"));
            bw.append("name,imei,model,price,color,capacity");
            bw.append("\n");
            for (Phone phone : ProductInventoryMap.values()) {
                bw.append(phone.getName());
                bw.append(',');
                bw.append(Integer.toString(phone.getImei()));
                bw.append(',');
                bw.append(phone.getModel());
                bw.append(',');
                bw.append(Double.toString(phone.getPrice()));
                bw.append(',');
                bw.append(phone.getColor());
                bw.append(',');
                bw.append(Integer.toString(phone.getCapacity()));
                bw.append('\n');
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
