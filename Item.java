import java.util.*;

public class Item {

	private Collection<OrderLineItem> product;
	private Collection<Store> store;
	private Collection<Price> prices;
	private Collection<UPC> productUpc;
	private String description;
	private STRING itemNumber;
	private UPC upcs;
	private TaxCategory taxCategory;
	private OrderLineItem orderLine;

	public void getPriceForQuantity() {
		// TODO - implement Item.getPriceForQuantity
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param price
	 */
	public void addPrice(Price price) {
		// TODO - implement Item.addPrice
		throw new UnsupportedOperationException();
	}

	public Item() {
		// TODO - implement Item.Item
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param price
	 */
	public void removePrice(Price price) {
		// TODO - implement Item.removePrice
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param date
	 */
	public void getTaxRateForDate(LocalDate date) {
		// TODO - implement Item.getTaxRateForDate
		throw new UnsupportedOperationException();
	}

}