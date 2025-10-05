import java.math.BigDecimal;

public class PayPal extends Payment {
    private String emailId;
    
    public PayPal(BigDecimal amount, String emailId) {
        super(amount);
        this.emailId = emailId;
    }
    
    public String getEmailId() {
        return emailId;
    }
}