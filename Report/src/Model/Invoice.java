package Model;

public class Invoice {
       private int id;
    private double amount;
    private int customerId;

     public Invoice(double amount, int customerId) {
        this.amount = amount;
        this.customerId = customerId;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
