import java.util.*;

public class Store {

	private Admin managedStore;
	private Collection<Item> storeItems;
	private Collection<TaxCategory> category;
	private Promo activepromo;
	private int storeID;
	private String address;
	private int zipCode;
	private localDate operatingHours;
	private String storeName;
	private Item items;
	private TaxCategory taxCategories;
	private Promo promo;

	public Store() {
		// TODO - implement Store.Store
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		// TODO - implement Store.addItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param number
	 */
	public void findItemByNumber(int number) {
		// TODO - implement Store.findItemByNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param category
	 */
	public TaxCategory findItemByTaxCategory(String category) {
		// TODO - implement Store.findItemByTaxCategory
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param taxCategory
	 */
	public void addTaxCategory(TaxCategory taxCategory) {
		// TODO - implement Store.addTaxCategory
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param taxCategory
	 */
	public void removeTaxCategory(TaxCategory taxCategory) {
		// TODO - implement Store.removeTaxCategory
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param upc
	 */
	public void addUPC(uPC upc) {
		// TODO - implement Store.addUPC
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param upc
	 */
	public void removeUPC(uPC upc) {
		// TODO - implement Store.removeUPC
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void removeItem(Item item) {
		// TODO - implement Store.removeItem
		throw new UnsupportedOperationException();
	}

}