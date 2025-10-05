import java.math.BigDecimal;

public class Cash extends Payment {
    private BigDecimal cashTendered;
    
    public Cash(BigDecimal amount, BigDecimal cashTendered) {
        super(amount);
        this.cashTendered = cashTendered;
    }
    
    public BigDecimal getCashTendered() {
        return cashTendered;
    }
}