package MODEL;

public class DigitalWallet extends PaymentMethod{
    private int WlletId;

    public DigitalWallet(String ownerName, double amount, int wlletId) {
        super(ownerName, amount);
        WlletId = wlletId;
    }

    public int getWlletId() {
        return WlletId;
    }

    public void setWlletId(int wlletId) {
        WlletId = wlletId;
    }

    @Override
    public void ProcessPayment() {
        String encriptedID=""+WlletId;
        System.out.println("Pago procesado de la cartera virtual terminada en:"+encriptedID.substring(encriptedID.length()-4));
        super.ProcessPayment();
    }
}
