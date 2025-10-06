package MODEL;

import java.util.Date;
public class Card extends PaymentMethod {
    private String CardNumber;
    private Date expiditionTime;
    private int CVV;
    public Card(String ownerName, double amount, String cardNumber, Date expiditionTime, int cVV) {
        super(ownerName, amount);
        CardNumber = cardNumber;
        this.expiditionTime = expiditionTime;
        CVV = cVV;
    }
    public String getCardNumber() {
        return CardNumber;
    }
    public void setCardNyumber(String cardNyumber) {
        CardNumber = cardNyumber;
    }
    public Date getExpiditionTime() {
        return expiditionTime;
    }
    public void setExpiditionTime(Date expiditionTime) {
        this.expiditionTime = expiditionTime;
    }
    public int getCVV() {
        return CVV;
    }
    public void setCVV(int cVV) {
        CVV = cVV;
    }
    
     @Override
    public void ProcessPayment() {
        System.out.println("Procesando pago con terjeta terminada en"+CardNumber.substring(CardNumber.length()-4));
        // TODO Auto-generated method stub
        super.ProcessPayment();
    }

}
