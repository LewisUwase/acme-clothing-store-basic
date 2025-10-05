import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;

import java.math.BigDecimal;

public class OrderTest {

    @Test
    void calculateSubtotalTaxAndTotal_withRealLineItems() {
        // subtotal = 25*2 + 15*1 = 65
        // tax (10%) = 6.5
        // total = 71.5
        Order order = new Order(null, false); // null account OK for tests
        Item speaker = new Item("Speaker", 25.0);
        Item earbuds = new Item("Earbuds", 15.0);

        order.addOrderLineItem(new OrderLineItem(speaker, 2));
        order.addOrderLineItem(new OrderLineItem(earbuds, 1));

        assertEquals(65.0, order.calculateSubtotal(), 1e-9);
        assertEquals(6.5, order.calculateTax(), 1e-9);
        assertEquals(71.5, order.calculateTotal(), 1e-9);
    }

    @Test
    void stubOrderLineItem_taxFree_orderTotalEqualsSubtotal() {
        // Use an anonymous subclass to stub getTotalPrice()
        Order order = new Order(null, true); // taxFree = true
        OrderLineItem stubLine = new OrderLineItem(new Item("stub", 0.0), 1) {
            @Override
            public double getTotalPrice() {
                return 100.0; // fixed subtotal provided by stub
            }
        };

        order.addOrderLineItem(stubLine);

        assertEquals(100.0, order.calculateSubtotal(), 1e-9);
        assertEquals(0.0, order.calculateTax(), 1e-9);    // taxFree => zero tax
        assertEquals(100.0, order.calculateTotal(), 1e-9);
    }

    @Test
    void mockPayment_isPaymentEnough_verifiesPaymentQueried() {
        // Order total = (10 * 3) = 30 + tax 3 = 33
        Order order = new Order(null, false);
        order.addOrderLineItem(new OrderLineItem(new Item("widget", 10.0), 3)); // total 33

        // Mockito mock for Payment
        Payment mockPayment = Mockito.mock(Payment.class);
        when(mockPayment.getAmount()).thenReturn(33.0);

        order.addPayment(mockPayment);

        assertTrue(order.isPaymentEnough());
        // verify Order called getAmount() on the payment
        verify(mockPayment, times(1)).getAmount();
    }

    @Test
    void realPayment_insufficientPayment_returnsFalse() {
        // Order total = 10 + tax 1 = 11
        Order order = new Order(null, false);
        order.addOrderLineItem(new OrderLineItem(new Item("widget", 10.0), 1));

        // real Payment object with 10.0 tendered
        Payment payment = new Payment(BigDecimal.valueOf(10.0));
        order.addPayment(payment);

        assertFalse(order.isPaymentEnough());
    }
}
