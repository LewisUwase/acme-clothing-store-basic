import java.math.BigDecimal;

public class Credit extends Payment {
    private String type;
    private String number;
    private String expDate;
    
    public Credit(BigDecimal amount, String type, String number, String expDate) {
        super(amount);
        this.type = type;
        this.number = number;
        this.expDate = expDate;
    }
    
    public String getType() {
        return type;
    }
    
    public String getNumber() {
        return number;
    }
    
    public String getExpDate() {
        return expDate;
    }
}