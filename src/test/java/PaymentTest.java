import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class PaymentTest {
    
    @Test
    void payment_getAmount_returnsCorrectDoubleValue() {
        // Test basic Payment functionality
        Payment payment = new Payment(BigDecimal.valueOf(49.99));
        
        assertEquals(49.99, payment.getAmount(), 1e-9);
        assertEquals(BigDecimal.valueOf(49.99), payment.getAmountAsBigDecimal());
    }
    
    @Test
    void payment_withZeroAmount_isValid() {
        // Edge case: zero payment
        Payment payment = new Payment(BigDecimal.ZERO);
        
        assertEquals(0.0, payment.getAmount(), 1e-9);
        assertEquals(BigDecimal.ZERO, payment.getAmountAsBigDecimal());
    }
    
    @Test
    void payment_withLargeAmount_maintainsPrecision() {
        // Test with large decimal value
        BigDecimal largeAmount = new BigDecimal("9999.99");
        Payment payment = new Payment(largeAmount);
        
        assertEquals(9999.99, payment.getAmount(), 1e-9);
        assertEquals(largeAmount, payment.getAmountAsBigDecimal());
    }
}