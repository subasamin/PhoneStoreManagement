package Repository;

import model.Phone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static controller.StoreController.AllProductMap;

public class ReadFileAllProduct {
    public static void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/data/AllProduct.csv"));
            String line;
            List<String> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            for (int i = 1; i < list.size(); i++) {
                String[] parts = list.get(i).split(",");
                String name = parts[0];
                int imei = Integer.parseInt(parts[1]);
                String model = parts[2];
                Double price = Double.parseDouble(parts[3]);
                String color = parts[4];
                int capacity = Integer.parseInt(parts[5]);
                AllProductMap.put(imei, new Phone(name,imei,model,price,color,capacity));
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
