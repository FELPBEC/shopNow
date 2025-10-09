package MODEL;

import java.time.LocalDate;

import javax.swing.JOptionPane;
public class Card extends PaymentMethod {
    private String CardNumber;
    private LocalDate expiditionTime;
    private int CVV;
    public Card(String ownerName, double amount, String cardNumber, LocalDate expiditionTime, int cVV) {
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
    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }
    public LocalDate getExpiditionTime() {
        return expiditionTime;
    }
    public void setExpiditionTime(LocalDate expiditionTime) {
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
        JOptionPane.showMessageDialog(null,"Procesando pago con tarjeta terminada en: "+CardNumber.substring(CardNumber.length()-4));
        super.ProcessPayment();
    }

}
