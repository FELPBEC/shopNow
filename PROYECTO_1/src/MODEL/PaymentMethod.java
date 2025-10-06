package MODEL;

public class PaymentMethod {
    private String ownerName;
    private double amount;
    
    public PaymentMethod(String ownerName, double amount) {
        this.ownerName = ownerName;
        this.amount = amount;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void ProcessPayment(){
        
    }
}
