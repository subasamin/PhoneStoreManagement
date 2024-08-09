package model;

public class Invoice {
    private int invoiceId;
    private Customer customer;
    private Phone products;
    private String date;

    public Invoice(int invoiceId, Customer customer, Phone products, String date) {
        this.invoiceId = invoiceId;
        this.customer = customer;
        this.products = products;
        this.date = date;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Phone getProducts() {
        return products;
    }

    public void setProducts(Phone products) {
        this.products = products;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", customer=" + customer +
                ", products=" + products +
                ", date='" + date + '\'' +
                '}';
    }
}
