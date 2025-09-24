import java.util.*;

public class Order {

	private PersonAccount account;
	private Shipping shipping;
	Collection<OrderLineItem> mainOrder;
	private Collection<Payment> payments;
	private date createDate;
	private Payment paymentMethod;
	private OrderLineItme orderlineItems;
	private Boolean taxFree;
	private PersonAccount person;

	public Order() {
		// TODO - implement Order.Order
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param payment
	 */
	public void addPayment(Payment payment) {
		// TODO - implement Order.addPayment
		throw new UnsupportedOperationException();
	}

	public void calcTotal() {
		// TODO - implement Order.calcTotal
		throw new UnsupportedOperationException();
	}

	public void calTax() {
		// TODO - implement Order.calTax
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param orderline
	 */
	public void addOrderlINEiTEM(OrderLineItem orderline) {
		// TODO - implement Order.addOrderlINEiTEM
		throw new UnsupportedOperationException();
	}

	public Boolean isPaymentEnough() {
		// TODO - implement Order.isPaymentEnough
		throw new UnsupportedOperationException();
	}

}