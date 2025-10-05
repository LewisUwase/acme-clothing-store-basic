package storefront;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class StoreTest {

    @Test
    void addFindRemoveItem_flow() {
        Store store = new Store(1, "MyStore", "123 Main St", 12345);
        Item a = new Item("Alpha", 9.99);
        Item b = new Item("Beta", 19.99);

        store.addItem(a);
        store.addItem(b);

        // find by name
        assertEquals(a, store.findItemByName("Alpha"));

        // find by price range
        List<Item> inRange = store.findItemsByPriceRange(5.0, 10.0);
        assertTrue(inRange.contains(a));
        assertFalse(inRange.contains(b));

        // remove and ensure gone
        store.removeItem(a);
        assertNull(store.findItemByName("Alpha"));
    }
}
