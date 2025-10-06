package MODEL;

public class BankTransfer extends PaymentMethod{
    private int AcountNumbrer;
    private String BankName;
    public BankTransfer(String ownerName, double amount, int acountNumbrer, String bankName) {
        super(ownerName, amount);
        AcountNumbrer = acountNumbrer;
        BankName = bankName;
    }
    public int getAcountNumbrer() {
        return AcountNumbrer;
    }
    public void setAcountNumbrer(int acountNumbrer) {
        AcountNumbrer = acountNumbrer;
    }
    public String getBankName() {
        return BankName;
    }
    public void setBankName(String bankName) {
        BankName = bankName;
    }

    @Override
    public void ProcessPayment() {
        String encriptedAcountNumber=""+AcountNumbrer;
        System.out.println("Procesando pago desde cuenta bancaria en la cuenta terminada en: "+encriptedAcountNumber.substring(encriptedAcountNumber.length()-4));
        System.out.println("en el banco"+ BankName);
        // TODO Auto-generated method stub
        super.ProcessPayment();
    }
    
    
}
