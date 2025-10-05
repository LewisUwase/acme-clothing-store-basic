package storefront;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private int storeID;
    private String storeName;
    private String address;
    private int zipCode;
    private LocalDate operatingHours; // Optional; might later represent open/close times
    private List<Item> storeItems;
    private List<TaxCategory> taxCategories;
    private Promo activePromo;
    private Admin managedStore;

    public Store(int storeID, String storeName, String address, int zipCode) {
        this.storeID = storeID;
        this.storeName = storeName;
        this.address = address;
        this.zipCode = zipCode;
        this.storeItems = new ArrayList<>();
        this.taxCategories = new ArrayList<>();
    }

    // Add a new item to the store
    public void addItem(Item item) {
        if (item != null && !storeItems.contains(item)) {
            storeItems.add(item);
        }
    }

    // Remove an item from the store
    public void removeItem(Item item) {
        storeItems.remove(item);
    }

    // Find item by name
    public Item findItemByName(String name) {
        for (Item item : storeItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    // Find item by price range
    public List<Item> findItemsByPriceRange(double min, double max) {
        List<Item> result = new ArrayList<>();
        for (Item item : storeItems) {
            if (item.getPrice() >= min && item.getPrice() <= max) {
                result.add(item);
            }
        }
        return result;
    }

    // Add and remove tax categories
    public void addTaxCategory(TaxCategory taxCategory) {
        if (taxCategory != null && !taxCategories.contains(taxCategory)) {
            taxCategories.add(taxCategory);
        }
    }

    public void removeTaxCategory(TaxCategory taxCategory) {
        taxCategories.remove(taxCategory);
    }

    // Getters
    public List<Item> getStoreItems() {
        return storeItems;
    }

    public String getStoreName() {
        return storeName;
    }

    public int getStoreID() {
        return storeID;
    }

    public String getAddress() {
        return address;
    }

    public int getZipCode() {
        return zipCode;
    }
}
