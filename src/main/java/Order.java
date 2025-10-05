
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Order {

    private PersonAccount account;
    private Shipping shipping;
    private Collection<OrderLineItem> orderLineItems;
    private Collection<Payment> payments;
    private Date createDate;
    private boolean taxFree;

    public Order(PersonAccount account, boolean taxFree) {
        this.account = account;
        this.taxFree = taxFree;
        this.createDate = new Date();
        this.orderLineItems = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public void addOrderLineItem(OrderLineItem item) {
        orderLineItems.add(item);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public double calculateSubtotal() {
        return orderLineItems.stream()
                .mapToDouble(OrderLineItem::getTotalPrice)
                .sum();
    }

    public double calculateTax() {
        if (taxFree) return 0.0;
        return calculateSubtotal() * 0.1; // 10% tax
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    public boolean isPaymentEnough() {
        double totalPaid = payments.stream()
                .mapToDouble(Payment::getAmount)
                .sum();
        return totalPaid >= calculateTotal();
    }

    public PersonAccount getAccount() {
        return account;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public boolean isTaxFree() {
        return taxFree;
    }

    public Collection<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public Collection<Payment> getPayments() {
        return payments;
    }
}
