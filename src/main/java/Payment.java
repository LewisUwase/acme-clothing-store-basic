
import java.math.BigDecimal;
import java.time.LocalDate;
public class Payment {

    private BigDecimal amount;

    public Payment(BigDecimal amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount.doubleValue();
    }

    public BigDecimal getAmountAsBigDecimal() {
        return amount;
    }
}
