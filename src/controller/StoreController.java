package controller;

import model.*;

import java.util.HashMap;

public class StoreController {
    public static HashMap<Integer,Phone> ProductInventoryMap = new HashMap<>();
    public static HashMap<Integer, Phone> ProductSoldMap = new HashMap<>();
    public static HashMap<Integer, Phone> AllProductMap = new HashMap<>();
    public static HashMap<Integer, Customer> CustomersMap = new HashMap<>();
    public static HashMap<Integer, Invoice> InvoiceMap = new HashMap<>();
}
